//Maxwell Plotkin COMP182
import java.util.Arrays;

public class Bubble {
	public static void sort(int[] array) {
		int len = array.length;
		int iter = 0;
		boolean unsorted = true;

		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < len - 1; ++i) {
				if (array[i + 1] < array[i]) {
					unsorted = true;

					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			System.out.println(iter++ + ": " + Arrays.toString(array));
		}

	}
}
