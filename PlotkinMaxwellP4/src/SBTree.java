class SBTree {
    private TNode root;

    private int getHeight(TNode N) {
        if (N == null)
            return 0;

        return N.height;
    }

    private int getLevelHeight(TNode node){
        if (node == null)
            return 0;
        else{
            int leftHeight = getLevelHeight(node.left);
            int rightHeight = getLevelHeight(node.right);

            if (leftHeight > rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }
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

    void insert(Feet value, int quantity) { this.root = this.insert(this.root, value, quantity); }

    private TNode insert(TNode node, Feet value, int quantity) {
        if (node == null)
            return (new TNode(value, quantity));

        if (value.lessThan(node.value))
            node.left = insert(node.left, value, quantity);
        else if (value.greaterThan(node.value))
            node.right = insert(node.right, value, quantity);
        else {
            node.quantity += quantity;
            return node;
        }

        node.height = 1 + max(getHeight(node.left),
                getHeight(node.right));

        int balance = getBalance(node);

        //left left
        if (balance > 1 && value.lessThan(node.left.value))
            return rightRotate(node);

        //right right
        if (balance < -1 && value.greaterThan(node.right.value))
            return leftRotate(node);

        //left right
        if (balance > 1 && value.greaterThan(node.left.value)) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //right left
        if (balance < -1 && value.lessThan(node.right.value)) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void delete(Feet value) { this.root = delete(root, value); }
    private TNode delete(TNode root, Feet value) {
        if (root == null)
            return null;

        if (value.lessThan(root.value))
            root.left = delete(root.left, value);
        else if (value.greaterThan(root.value))
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
                root.quantity = temp.quantity;
                root.right = delete(root.right, temp.value);
            }
        }

        if (root == null)
            return null;

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



    private Feet minValue(TNode root)
    {
        Feet min = root.value;

        while (root.left != null)
        {
            min = root.left.value;
            root = root.left;
        }

        return min;
    }

    private TNode minValueNode(TNode node) {
        TNode current = node;

        while (current.left != null)
           current = current.left;

        return current;
    }

    public String toString() { return this.toPreOrder(root); }
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

    String toLevelOrder() {return this.toLevelOrder(root);}
    private String toLevelOrder(TNode node){
        String out = "";
        int height = getLevelHeight(node);
        for(int i = 1; i <= height; ++i)
            out += levelToString(node, i);

        return out;
    }

    private String levelToString(TNode node, int level){
        if (node == null)
            return ",";
        if(level == 1)
            return node.value + ",";
        else if(level > 1){
            return levelToString(node.left, level-1)
                + levelToString(node.right, level-1);
        }
        return "";
    }

    TNode find(Feet value){return find(root, value);}
    private TNode find(TNode root, Feet value) {
        if (root == null)
            return null;

        if (value.lessThan(root.value))
            return find(root.left, value);
        else if (value.greaterThan(root.value))
            return find(root.right, value);
        else
            return root;
    }

    boolean isEmpty(){
        return root == null;
    }
}
