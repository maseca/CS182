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
				System.out.println("j " + j + ": " + Arrays.toString(array));
			}
			System.out.println(i + ": " + Arrays.toString(array));
		}
	}

	public static void insertion (int[] array) {
		int len = array.length;

		for(int i = 1; i < len; ++i){
			for(int j = i; j > 0; --j){
				if(array[j] < array[j-1]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				System.out.println("j: " + j + ": " + Arrays.toString(array));
			}

			System.out.println(i + ": " + Arrays.toString(array));
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
			System.out.println(i + ": " + Arrays.toString(array));
			System.out.println("index: " + index);
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
			if(iL < lenL && iR < lenR) {
				if (l[iL] < r[iR])
					a[iA++] = l[iL++];
				else
					a[iA++] = r[iR++];
			}else {
				if (iL >= lenL)
					while (iR < lenR)
						a[iA++] = r[iR++];
				if (iR >= lenR)
					while (iL < lenL)
						a[iA++] = l[iL++];
			}
		}
	}

	static void myQuick(int arr[]){
		int pivot = (arr[0] + arr[arr.length-1]) / 2;
		boolean swapped = true;

		while(swapped){

		}
	}

    static int myPartition(int arr[], int low, int high)
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

	private static void swap(int[] arr, int pos1, int pos2){
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	public static void quick(int[] arr){ quick(arr, 0, arr.length-1);}

	public static void quick(int[] arr, int lowest, int highest){
		if(lowest < highest){
			int part = partition(arr, lowest, highest);
			System.out.println("Partition: " + part);
			System.out.println("QS: "+ Arrays.toString(arr));
			quick(arr, lowest, part-1);
			quick(arr, part+1, highest);
		}
	}

	private static int partition(int[] arr, int low, int high){
		int pivot = arr[high], small = low-1;
		for(int x = low; x < high; x++) {
			if (arr[x] <= pivot) {
				small++;
				System.out.println("PART BEFORE 1ST SWAP: " + Arrays.toString(arr));
				swap(arr, x, small);
				System.out.println("PART AFTER 1ST SWAP: " + Arrays.toString(arr));
			}
		}
		System.out.println("PART BEFORE 2ND SWAP: "+ Arrays.toString(arr));
		swap(arr, small+1, high);
		System.out.println("PART AFTER 2ND SWAP: "+ Arrays.toString(arr));
		return small+1;
	}

	public static void indexPartition(int[] arr, int low, int high){
		int pivot = (low+high)/2;
		do{
			if(arr[low] < arr[pivot]) low++;
			if(arr[pivot] < arr[high]) high--;
			if(arr[low] >= arr[pivot] && arr[high] <= arr[pivot]) {
				swap(arr, low, high);
				low++;
				high--;
			}
			System.out.println("PIVOT: " + pivot + " || LOWEST: " + low + " || HIGHEST: " + high);
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}while(low < high);
	}

    static void quickRec(int arr[]){ quickRec(arr, 0, arr.length-1); }
    static void quickRec(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = myPartition(arr, low, high);
            //System.out.println(pi);

            // Recursively sort elements before
            // partition and after partition
            quickRec(arr, low, pi-1);
            quickRec(arr, pi+1, high);
        }
    }
}
