class SBTree {
    TNode root;

    private int getHeight(TNode N) {
        if (N == null)
            return 0;

        return N.height;
    }

    private int max(int a, int b) { return (a > b) ? a : b; }

    private TNode rightRotate(TNode y) {
        TNode x = y.left;
        TNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private TNode leftRotate(TNode x) {
        TNode y = x.right;
        TNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    private int getBalance(TNode N) {
        if (N == null)
            return 0;
        return getHeight(N.left) - getHeight(N.right);
    }

    void insert(int value){ this.root = this.insert(this.root, value); }
    private TNode insert(TNode node, int value) {
        if (node == null)
            return (new TNode(value));

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else //no duplicates
            return node;

        node.height = 1 + max(getHeight(node.left),
                              getHeight(node.right));

        int balance = getBalance(node);

        //left left
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        //right right
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        //left right
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //right left
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void delete(int value) { this.root = delete(root, value); }
    private TNode delete(TNode root, int value)
    {
        if (root == null)
            return null;

        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);
            root.right = delete(root.right, root.value);
        }

        return root;
    }

    private int minValue(TNode root)
    {
        int minv = root.value;

        while (root.left != null)
        {
            minv = root.left.value;
            root = root.left;
        }

        return minv;
    }

	String toPreOrder() { return this.toPreOrder(root); }
	private String toPreOrder(TNode node){
		String parent, left, right;
		parent = left = right = "";

		if(node != null) {
			parent = node.toString();

			if (node.left != null)
				left = toPreOrder(node.left);
			if (node.right != null)
				right = toPreOrder(node.right);
		}
		return parent + left + right;
	}

    String toInOrder() { return this.toInOrder(root); }
    private String toInOrder(TNode node){
        String parent, left, right;
        parent = left = right = "";

        if(node != null) {
            parent = node.toString();

            if (node.left != null)
                left = toInOrder(node.left);
            if (node.right != null)
                right = toInOrder(node.right);
        }
        return left + parent + right;
    }

    String toPostOrder() { return this.toPostOrder(root); }
    private String toPostOrder(TNode node){
        String parent, left, right;
        parent = left = right = "";

        if(node != null) {
            parent = node.toString();

            if (node.left != null)
                left = toPostOrder(node.left);
            if (node.right != null)
                right = toPostOrder(node.right);
        }
        return left + right + parent;
    }

}
