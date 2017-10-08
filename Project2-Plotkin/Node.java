//Maxwell Plotkin
//COMP182 10/7/2017
//Node

public class Node {
	//attributes
	private int info = 0;
	private Node next = null;

	//constructors
	Node(int i, Node n) {
		info = i;
		next = n;
	}//cons
	Node(int i) {
		info = i;
		next = null;
	}//cons

	//methods
	int getInfo() { return info; }
	public void setInfo(int i) { info = i; }

	Node getNext() { return next; }
	void setNext(Node n) { next = n; }

	public String toString() { return "" + info;}
}//node
