import java.util.Arrays;

public class Merge{
	static void sort(int[] arr){
		_split(arr);
	}

	private static void _split(int[] arr){
		int len = arr.length;
		if(len > 1){
			int[] left = Arrays.copyOfRange(arr, 0, (len / 2) - 1);
			int[] right = Arrays.copyOfRange(arr, len / 2, len - 1);

			_split(left);
			_split(right);

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
}