import java.util.Arrays;
import java.util.Scanner;

public class SBTreeTest {
	public static void main(String[] args) {
		String in;
		Scanner sc = new Scanner(System.in);

		System.out.println("Input integers separated by spaces:");
		try {
			in = sc.nextLine().replaceAll("\\s{2,}"," ").trim();
		} catch (Exception e) {
			System.err.println("No input detected.");
			in = "0";
		}

		System.out.print("Pre-Sorted: ");
		System.out.println(treeFromStr(in));

		/*
		int[] ary = aryFromStr(in);
		SortArray.insertion(ary);
		System.out.println("Sorted: " + Arrays.toString(ary));
		*/
}

	private static int[] aryFromStr(String inStr){
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

	private static SBTree treeFromStr(String inStr){
		String[] strAry = inStr.split(" ");
		SBTree tree = new SBTree();
		int i = 0;

		for (String num : strAry) {
			try {
				i = Integer.parseInt(num);
			} catch (Exception e) {
				System.err.println("Failed to parse: " + num);
			}

			tree.add(i);
			//System.out.println(num);
			//System.out.println(tree.toString());
		}

		return tree;
	}
}
