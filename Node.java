//Maxwell Plotkin COMP182
public class Node {
	//attributes
	private int info = 0;
	private Node next = null;

	//constructors
	Node(int i, Node n) {
		info = i;
		next = n;
	}
	Node(int i) {
		info = i;
		next = null;
	}

	//methods
	int getInfo() { return info; }
	public void setInfo(int i) { info = i; }

	Node getNext() { return next; }
	void setNext(Node n) { next = n; }

	public String toString() { return "" + info;}
}
