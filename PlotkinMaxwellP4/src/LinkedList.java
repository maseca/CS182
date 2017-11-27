//Maxwell Plotkin COMP182
public class LinkedList {
	//attributes
	Node head;

	//constructors
	LinkedList() { head = null; }
	public LinkedList(Node h) { head = h; }

	//methods
	Node getHead() { return head; }
	void setHead(Node h) { head = h; }

	public String toString() {
		if(head == null)
			return "null";

		return this._toString(head);
	}

	private String _toString(Node itr) {
		if (itr.getNext() == null)
			return "" + itr;

		return itr + _toString(itr.getNext());
	}

	void inAfterHead(TNode i) { head.setNext(new Node(i)); }
}
