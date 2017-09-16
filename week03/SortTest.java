//Maxwell Plotkin COMP182
import java.util.Arrays;
import java.util.Scanner;

public class SortTest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Input integers separated by spaces:");
		String in;

		try{
			in = sc.nextLine().trim();
		}catch(Exception e){
			System.err.println("No input detected.");
			in = "0";
		}

		int[] ary = aryFromStr(in);

		System.out.println("Initial: " + Arrays.toString(ary));
		Selection.sort(ary);
		System.out.println("Final: " + Arrays.toString(ary));
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
