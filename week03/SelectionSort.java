//Maxwell Plotkin COMP182
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Input integers separated by spaces:");
		String in = sc.nextLine().trim();
		int[] ary = aryFromStr(in);

		System.out.println("Initial: " + Arrays.toString(ary));
		selSort(ary);
		System.out.println("Final: " + Arrays.toString(ary));
	}

	public static void selSort(int[] array){
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

	public static int[] aryFromStr(String inStr){
		String[] strAry = inStr.split(" ");
		int sLen = strAry.length;
		int[] intAry = new int[sLen];

		for(int i=0; i < sLen; ++i){
			try {
				intAry[i] = Integer.parseInt(strAry[i]);
			}catch(Exception e){
				System.err.println("Failed to parse: " + strAry[i]);
			}
		}

		return intAry;
	}
}
