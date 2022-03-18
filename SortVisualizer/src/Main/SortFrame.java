package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class SortFrame extends JFrame {

	JPanel wrapper, sort, buttons;
	JPanel[] bars;
	JButton start, bubbleSort, mergeSort, insertionSort, selectionSort, reset;
	String selection;
	GridBagConstraints c;
	final int size = 100, width = 5;
	int[] values;

	public SortFrame() {

		start = new JButton("Start");
		bubbleSort = new JButton("Bubble Sort");
		mergeSort = new JButton("Merge Sort");
		insertionSort = new JButton("Insertion Sort");
		selectionSort = new JButton("Selection Sort");
		reset = new JButton("Reset");

		buttons = new JPanel();
		sort = new JPanel();
		wrapper = new JPanel();
		sort.setBackground(Color.gray);

		c = new GridBagConstraints();

		buttons.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortingVisualizer.start(selection);
			}
		});

		buttons.add(bubbleSort);
		bubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection = "Bubble";
				if (!SortingVisualizer.currentlySorting) {
					resetButtonColors();
					bubbleSort.setBackground(Color.green);
				}
			}
		});

		buttons.add(mergeSort);
		mergeSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection = "Merge";
				if (!SortingVisualizer.currentlySorting) {
					resetButtonColors();
					mergeSort.setBackground(Color.green);
				}
			}
		});

		buttons.add(insertionSort);
		insertionSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection = "Insertion";
				if (!SortingVisualizer.currentlySorting) {
					resetButtonColors();
					insertionSort.setBackground(Color.green);
				}
			}
		});

		buttons.add(selectionSort);
		selectionSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection = "Selection";
				if (!SortingVisualizer.currentlySorting) {
					resetButtonColors();
					selectionSort.setBackground(Color.green);
				}
			}
		});

		buttons.add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortingVisualizer.reset();
			}
		});

		sort.setLayout(new GridBagLayout());
		wrapper.setLayout(new BorderLayout());

		c.insets = new Insets(1, 1, 1, 1);
		c.anchor = GridBagConstraints.SOUTH;

		wrapper.add(buttons, BorderLayout.NORTH);
		wrapper.add(sort);
		add(wrapper);
	}

	public void resetButtonColors() {
		selectionSort.setBackground(UIManager.getColor("Button.background"));
		mergeSort.setBackground(UIManager.getColor("Button.background"));
		bubbleSort.setBackground(UIManager.getColor("Button.background"));
		insertionSort.setBackground(UIManager.getColor("Button.background"));
	}

	public void drawBars(int green, int red) {
		bars = new JPanel[100];
		sort.removeAll();
		this.values = SortingVisualizer.values;
		for (int x = 0; x < size; x++) {
			bars[x] = new JPanel();
			bars[x].setPreferredSize(new Dimension(width, values[x] * 5));
			bars[x].setBackground(Color.white);

			if (x == green)
				bars[x].setBackground(Color.green);
			if (x == red)
				bars[x].setBackground(Color.red);

			sort.add(bars[x], c);
		}
		repaint();
		validate();
	}

}
