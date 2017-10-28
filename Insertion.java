//Maxwell Plotkin COMP182
import java.util.Arrays;

public class Insertion{
	public static void sort(int[] array) {
		int len = array.length;

		for(int i = 1; i < len; ++i){
			for(int j = 0; j < i; ++j){
				if(array[i] < array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

			System.out.println(i-1 + ": " + Arrays.toString(array));
		}
	}
}

