import java.util.Scanner;

public class SBTreeTest {
	public static void main(String[] args) {
		SBTree sbTree;
		String in;
		Scanner sc = new Scanner(System.in);

		System.out.println("Input integers separated by spaces:");
		try {
			in = sc.nextLine().replaceAll("\\s{2,}", " ").trim();
		} catch (Exception e) {
			System.err.println("No input detected.");
			in = "0";
		}

		sbTree = treeFromStr(in);

		sbTree.delete(20);
		sbTree.insert(5);
		sbTree.delete(61);
		sbTree.insert(79);

		System.out.print("Pre-Ordered: ");
		System.out.println(sbTree.toPreOrder());
		System.out.print("In-Ordered: ");
		System.out.println(sbTree.toInOrder());
		System.out.print("Post-Ordered: ");
		System.out.println(sbTree.toPostOrder());
		System.out.print("Level-Ordered: ");
		System.out.println(sbTree.toLevelOrder());

	}

	private static SBTree treeFromStr(String inStr){
        String[] strAry = inStr.split(" ");
        SBTree tree = new SBTree();
        int i = 0;

		for (String num : strAry) {
            try { i = Integer.parseInt(num);
            } catch (Exception e) {
                System.err.println("Failed to parse: " + num);
            }

            tree.insert(i);
        }

		return tree;
    }
}
