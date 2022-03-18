package Sorts;

import Main.SortingVisualizer;

public class InsertionSort implements Runnable {

	int[] values;

	public void run() {
		values = SortingVisualizer.values;
		SortingVisualizer.currentlySorting = true;
		sort();
		SortingVisualizer.f.drawBars(-1, -1);
		SortingVisualizer.currentlySorting = false;
	}

	public void sort() {
		int toInsert = 0;
		int place = 0;
		for (int i = 1; i < values.length; i++) {
			place = i;
			for (int j = i - 1; j >= 0; j--) {
				if (values[i] < values[j]) {
					place = j;
					SortingVisualizer.f.drawBars(i, place);
					try {
						Thread.sleep(SortingVisualizer.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			toInsert = values[i];
			for (int x = i; x > place; x--) {
				values[x] = values[x - 1];
			}
			values[place] = toInsert;
		}
	}
}