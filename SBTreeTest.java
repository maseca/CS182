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

		System.out.print("Pre-Ordered: ");
		System.out.println(treePre(in));
		System.out.print("In-Ordered: ");
		System.out.println(treeIn(in));
		System.out.print("Post-Ordered: ");
		System.out.println(treePost(in));

		//SortArray.insertion(ary);
		//System.out.println("Sorted: " + Arrays.toPreOrder(ary));
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

	private static String treePre(String inStr){
		String[] strAry = inStr.split(" ");
		SBTree tree = new SBTree();
		int i = 0;

		for (String num : strAry) {
			try {
				i = Integer.parseInt(num);
			} catch (Exception e) {
				System.err.println("Failed to parse: " + num);
			}

			tree.insert(i);
		}
		return tree.toPreOrder();
	}
	private static String treePost(String inStr){
		String[] strAry = inStr.split(" ");
		SBTree tree = new SBTree();
		int i = 0;

		for (String num : strAry) {
			try {
				i = Integer.parseInt(num);
			} catch (Exception e) {
				System.err.println("Failed to parse: " + num);
			}

			tree.insert(i);
		}
		return tree.toPostOrder();
	}
	private static String treeIn(String inStr){
		String[] strAry = inStr.split(" ");
		SBTree tree = new SBTree();
		int i = 0;

		for (String num : strAry) {
			try {
				i = Integer.parseInt(num);
			} catch (Exception e) {
				System.err.println("Failed to parse: " + num);
			}

			tree.insert(i);
		}
		return tree.toInOrder();
	}
}
