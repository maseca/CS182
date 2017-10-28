//Maxwell Plotkin COMP182
public class TNode {
	//attributes
	private int info = 0;
	private int height = 1;
	private TNode left = null;
	private TNode right = null;

	//constructors
	TNode(int i, TNode l, TNode r) {
		this.info = i;
		this.left = l;
		this.right = r;
	}

	TNode(int i) { info = i; }

	//methods
	void add(int x){
		if (x < this.info) {
			if (this.left != null)
				this.left.add(x);
			else
				this.left = new TNode(x);

			if (this.right == null || this.right.height < this.left.height)
				this.height = this.left.height + 1;
		}
		else {
			if (this.right != null)
				this.right.add(x);
			else
				this.right = new TNode(x);

			if (this.left == null || this.right.height > this.left.height)
				this.height = this.right.height + 1;
		}
		this.balance();
	}

	private void balance() {
		int heightR, heightL;
		heightR = heightL = 0;

		if(this.right != null)
			heightR = this.right.height;
		if(this.left != null)
			heightL = this.left.height;

		if(heightL > heightR + 1){
			int leftHeightR, leftHeightL;
			leftHeightR = leftHeightL = 0;

			if(this.left.right != null)
				leftHeightR = this.left.right.height;
			if(this.left.left != null)
				leftHeightR = this.left.left.height;

			if(leftHeightR > leftHeightL)
				this.left.rotateRR();

			this.rotateLL();
		}else if(heightR > heightL + 1){
			int rightHeightR, rightHeightL;
			rightHeightR = rightHeightL = 0;

			if(this.right.right != null)
				rightHeightR = this.right.right.height;
			if(this.right.left != null)
				rightHeightR = this.right.left.height;

			if(rightHeightR > rightHeightL)
				this.right.rotateLL();

			this.rotateRR();
		}
	}

	private void rotateRR(){
		int tempInfo = this.info;
		TNode tempLeft = this.left;

		this.info = this.right.info;
		this.left = this.right;
		this.right = this.right.right;
		this.left.right = this.left.left;
		this.left.left = tempLeft;
		this.left.info = tempInfo;

		this.left.updateLocation();
		this.updateLocation();
	}

	private void rotateLL() {
		int tempInfo = this.info;
		TNode tempRight = this.right;

		this.info = this.left.info;
		this.right = this.left;
		this.left = this.left.left;
		this.right.left = this.right.right;
		this.right.right = tempRight;
		this.right.info = tempInfo;

		this.right.updateLocation();
		this.updateLocation();
	}

	private void updateLocation(){
		if(this.right == null && this.left == null)
			this.height = 1;
		else if(this.right == null || (this.left != null && this.right.height < this.left.height))
			this.height = this.left.height + 1;
		else
			this.height = this.right.height + 1;
	}

	int getInfo() { return info; }
	public void setInfo(int i) { info = i; }

	public TNode getRight() { return right; }
	public void setRight(TNode right) { this.right = right; }

	public TNode getLeft() { return left; }
	public void setLeft(TNode left) { this.left = left; }

	public String toString() { return "" + info;}
}
