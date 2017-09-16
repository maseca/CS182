//Maxwell Plotkin COMP182
import java.util.Arrays;

public class Selection {
	public static void sort(int[] array){
		int len = array.length;

		for(int i = 0; i < len-1; i++){
			int index = i;

			for(int j = i+1; j < len; j++){
				if(array[j] < array[index])
					index = j;
			}

			int num = array[index];
			array[index] = array[i];
			array[i] = num;
			System.out.println(i + ": " + Arrays.toString(array));
		}
	}
}
