//Maxwell Plotkin COMP182
import java.util.Arrays;

public class SortArray {
	public static void bubble (int[] array) {
		int len = array.length;

		for (int i = 0; i < len - 1; ++i) {
			for(int j = 1; j < len - i; ++j) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
			//System.out.println(i + ": " + Arrays.toString(array));
		}
	}

	public static void insertion (int[] array) {
		int len = array.length;

		for(int i = 1; i < len; ++i){
			for(int j = 0; j < i; ++j){
				if(array[i] < array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

			//System.out.println(i-1 + ": " + Arrays.toString(array));
		}
	}

	public static void selection(int[] array){
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
			//System.out.println(i + ": " + Arrays.toString(array));
		}
	}

    public static void heap(int[] arr) {
        int len = arr.length;
        int numPercs = 1;

	    System.out.println("Heapify:");
        for(int i = len / 2 - 1; i >= 0; --i) {
	        percDown(arr, len, i);
	        System.out.println("Perc# " + numPercs++ + ": " + Arrays.toString(arr));
        }
        numPercs = 1;

	    System.out.println("Sort:");
	    for(int i = len - 1; i >= 0; --i){
	    	int temp = arr[0];
	    	arr[0] = arr[i];
	    	arr[i] = temp;

	    	percDown(arr, i, 0);
		    System.out.println("Perc# " + numPercs++ + ": " + Arrays.toString(arr));
	    }
    }

    public static void percDown(int[] arr, int size, int root){
	    int largest = root;
        int l = 2*root + 1;
        int r = 2*root + 2;

        if(l < size && arr[l] > arr[largest])
        	largest = l;
	    if(r < size && arr[r] > arr[largest])
		    largest = r;

	    if(largest != root){
		    int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            percDown(arr, size, largest);
	    }
    }


}
