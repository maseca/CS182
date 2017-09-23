//Maxwell Plotkin COMP182
import java.util.Arrays;

public class Bubble {
	public static void sort(int[] array) {
		int len = array.length;

		for (int i = 0; i < len - 1; ++i) {
			for(int j = 1; j < len - i; ++j) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
				System.out.println("inner" + j + ": " + Arrays.toString(array));
			}
			System.out.println(i + ": " + Arrays.toString(array));
		}
	}
}
