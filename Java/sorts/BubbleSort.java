package sorts;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = { 4, 5, 0, 6, 2, 7, 1, 9, 3, 8 };
		boolean reverse = true;
		for (int i : array) {
			boolean inOrder = true;
			for (int j = 0; j < array.length - 1; j++) {
				if (reverse) {
					if (array[j] < array[j + 1]) {
						inOrder = false;
						int aux = array[j];
						array[j] = array[j + 1];
						array[j + 1] = aux;
					}

				} else {
					if (array[j] > array[j + 1]) {
						inOrder = false;
						int aux = array[j];
						array[j] = array[j + 1];
						array[j + 1] = aux;
					}
				}
			}
			if (inOrder) {
				break;
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
