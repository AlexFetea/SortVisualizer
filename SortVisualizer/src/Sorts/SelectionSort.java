package Sorts;

import Main.SortingVisualizer;

public class SelectionSort implements Runnable {

	int[] values;

	public void run() {
		values = SortingVisualizer.values;
		SortingVisualizer.currentlySorting = true;
		sort();
		SortingVisualizer.f.drawBars(-1, -1);
		SortingVisualizer.currentlySorting = false;
	}

	public void sort() {
		for (int i = 0; i < values.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < values.length; j++) {
				if (values[j] < values[min])
					min = j;
				SortingVisualizer.f.drawBars(min, j - 1);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int temp = values[min];
			values[min] = values[i];
			values[i] = temp;
		}
	}

}
