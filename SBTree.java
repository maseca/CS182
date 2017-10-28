public class SBTree {
	private TNode root = null;

	public void add(int x){
		if(this.root == null)
			this.root = new TNode(x);
		else
			this.root.add(x);
	}
}
