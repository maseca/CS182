//Maxwell Plotkin
//COMP182 10/7/2017
//Linked List

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

		return this.toString(head);
	}//toString
	private String toString(Node itr) {
		if (itr.getNext() == null)
			return "" + itr;

		return itr + ", " + toString(itr.getNext());
	}//toString

	void inAfterHead(int i) { head.setNext(new Node(i)); }
}//linkedList
