import java.util.ArrayList;

class SBTree {
	private TNode root;

	//methods
	private int heightOf(TNode n){
		if(n == null)
			return 0;
		return n.height;
	}

	private int maxOf(int a, int b){ return (a > b) ? a : b; }

	private int getBalance(TNode n){
		if(n == null)
			return 0;
		return heightOf(n.left) - heightOf(n.right);
	}

	private TNode rotateRight(TNode n){
		TNode left = n.left;
		TNode leftRight = left.right;

		left.right = n;
		n.left = leftRight;

		n.height = maxOf(heightOf(n.left), heightOf(n.right)) + 1;
		left.height = maxOf(heightOf(left.left), heightOf(left.right)) + 1;

		return left;
	}

	private TNode rotateLeft(TNode n){
		TNode right = n.right;
		TNode rightLeft = right.left;

		right.left = n;
		n.right = rightLeft;

		n.height = maxOf(heightOf(n.left), heightOf(n.right)) + 1;
		right.height = maxOf(heightOf(right.left), heightOf(right.right)) + 1;

		return right;
	}

	void add(int x){ root = add(root, x); }
	private TNode add(TNode n, int value) { //no duplicates
		if (n == null)
			return (new TNode(value));

		if (value < n.value)
			n.left = add(n.left, value);
		else if (value > n.value)
			n.right = add(n.right, value);
		else
			return n;

		n.height = 1 + maxOf(heightOf(n.left), heightOf(n.right));

		int balance = getBalance(n);

		if (balance > 1 && value < n.left.value)
			return rotateRight(n);

		if (balance < -1 && value > n.right.value)
			return rotateLeft(n);

		if (balance > 1 && value > n.left.value) {
			n.left = rotateLeft(n.left);
			return rotateRight(n);
		}

		if (balance < -1 && value < n.right.value) {
			n.right = rotateRight(n.right);
			return rotateLeft(n);
		}

		return n;
	}

	public String toString() { return this.toString(root); }
	private String toString(TNode node){
		String parent, left, right;
		parent = left = right = "";

		if(node != null) {
			parent = node.toString();

			if (node.left != null)
				left = toString(node.left);
			if (node.right != null)
				right = toString(node.right);
		}
		return parent + left + right;
	}
}
