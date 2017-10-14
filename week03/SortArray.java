//Maxwell Plotkin COMP182
import java.util.ArrayList;
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

    private static void percDown(int[] arr, int size, int root){
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

	public static void merge(int[] arr){
		int len = arr.length;
		if(len > 1){
			int[] left = Arrays.copyOfRange(arr, 0, (len / 2) - 1);
			int[] right = Arrays.copyOfRange(arr, len / 2, len - 1);

			merge(left);
			merge(right);

			_merge(arr, left, right);
		}
	}

	private static void _merge(int[] a, int[] l, int[] r){
		int lenL = l.length;
		int lenR = r.length;
		int total = lenL + lenR;
		int iA, iL, iR;
		iA = iL = iR = 0;

		while (iA < total){
			if(iL < lenL && iR < lenR)
				if (l[iL] < r[iR])
					a[iA++] = l[iL++];
				else
					a[iA++] = r[iR++];
			else
			if(iL >= lenL)
				while(iR < lenR)
					a[iA++] = r[iR++];
			if(iR >= lenR)
				while(iL < lenL)
					a[iA++] = l[iL++];
		}
	}

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    static void quick(int arr[]){
    	quick(arr, 0, arr.length-1);
    }
    static void quick(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quick(arr, low, pi-1);
            quick(arr, pi+1, high);
        }
    }
}
