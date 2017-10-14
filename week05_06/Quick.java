import java.util.ArrayList;

public class Quick {
	static void sort(int[] arr){
		int len = arr.length;

		if(len > 1){
			ArrayList<Integer> left, right;
			left = right = new ArrayList<Integer>();
			int pivot = arr[len - 1];

			for(int i = 0; i < len - 1; ++i){
				if(i > pivot)
					right.add(arr[i]);
				else
					left.add(arr[i]);
			}

			int leftSize = left.size();
			int rightSize = right.size();
			int[] arrL = new int[leftSize + 1];
			int[] arrR = new int[rightSize];

			for(int i = 0; i < leftSize; ++i)
				arrL[i] = left.get(i);

			arrL[leftSize] = pivot;

			for(int i = 0; i < rightSize; ++i)
				arrR[i] = right.get(i);

			sort(arrL);
			sort(arrR);

			System.arraycopy(left, 0, arr, 0, leftSize);
			System.arraycopy(right, 0, arr, leftSize, rightSize);
		}
	}
}
