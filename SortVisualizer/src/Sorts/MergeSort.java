package Sorts;

import Main.SortingVisualizer;

public class MergeSort implements Runnable {

	public void run() {
		int[] values = SortingVisualizer.values;
		SortingVisualizer.currentlySorting = true;
		merge(values, 0, values.length - 1);
		SortingVisualizer.f.drawBars(-1, -1);
		SortingVisualizer.currentlySorting = false;
	}

	private void merge(int[] values, int first, int last) {
		if (first == last)
			return;

		int temp, left, right, mid = (first + last) / 2;

		merge(values, first, mid);
		merge(values, mid + 1, last);

		left = first;
		right = mid + 1;

		while (left <= mid && right <= last) {
			if (values[left] <= values[right])
				left++;
			else {
				temp = values[right];
				for (int i = right - left; i > 0; i--) {
					values[left + i] = values[left + i - 1];
				}
				values[left] = temp;
				left++;
				mid++;
				right++;
			}
			SortingVisualizer.f.drawBars(mid, right);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
