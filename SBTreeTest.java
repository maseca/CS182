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

		System.out.println(treeFromStr(in));
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
			System.out.println(tree.toString());
		}

		return tree;
	}
}
