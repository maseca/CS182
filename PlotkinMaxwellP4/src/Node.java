//Maxwell Plotkin COMP182 12/9/2017
//Node for garbage stack traversal
public class Node {
	//attributes
	private TNode info = null;
	private Node next = null;

	//constructors
	Node(TNode i, Node n) { info = i; next = n; }
	Node(TNode i) { info = i; next = null; }

	//methods
	TNode getInfo() { return info; }
	public void setInfo(TNode i) { info = i; }

	Node getNext() { return next; }
	void setNext(Node n) { next = n; }

	public String toString() { return "" + info;}
}//Node
