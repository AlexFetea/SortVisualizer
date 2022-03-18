package Main;

import javax.swing.JFrame;

import Sorts.BubbleSort;
import Sorts.InsertionSort;
import Sorts.MergeSort;
import Sorts.SelectionSort;

public class SortingVisualizer {

	private static Thread thread;

	public static SortFrame f;
	public static int[] values;
	public static boolean currentlySorting = false;
	public static int size = 100, width = 5, sleep = 1;

	public static void main(String[] args) {
		f = new SortFrame();
		f.setSize(800, 600);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reset();

	}

	public static void reset() {
		values = new int[size];
		for (int i = 0; i < values.length; i++) {
			values[i] = (int) (size * Math.random());
		}
		f.drawBars(-1, -1);

	}

	public static void start(String sortType) {
		if (!currentlySorting) {
			if (sortType.equals("Bubble"))
				thread = new Thread(new BubbleSort());
			else if (sortType.equals("Selection"))
				thread = new Thread(new SelectionSort());
			else if (sortType.equals("Insertion"))
				thread = new Thread(new InsertionSort());
			else if (sortType.equals("Merge"))
				thread = new Thread(new MergeSort());
			else {
				return;
			}
		}
		thread.start();

	}

}
