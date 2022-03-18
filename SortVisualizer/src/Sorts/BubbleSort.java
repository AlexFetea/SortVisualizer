package Sorts;

import Main.SortingVisualizer;

public class BubbleSort implements Runnable {
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
			for (int j = 0; j < values.length - i - 1; j++) {
				if (values[j] > values[j + 1]) {
					int temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}
				SortingVisualizer.f.drawBars(j + 1, j + 2);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}