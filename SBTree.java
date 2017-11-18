class SBTree {
    TNode root;

    private int getHeight(TNode N) {
        if (N == null)
            return 0;

        return N.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

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

    void insert(int value) {
        this.root = this.insert(this.root, value);
    }

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

    void delete(int value) {
        this.root = delete(root, value);
    }

    private TNode delete(TNode root, int value) {
        if (root == null)
            return null;

        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);
        else {
            if ((root.left == null) || (root.right == null)) {
                TNode temp = null;
                if (null == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else   // One child case
                    root = temp;
            } else {
                TNode temp = minValueNode(root.right);
                root.value = temp.value;
                root.right = delete(root.right, temp.value);
            }
        }

        if (root == null)
            return root;

        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
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

    TNode minValueNode(TNode node) {
        TNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
           current = current.left;

        return current;
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
