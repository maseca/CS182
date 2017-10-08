//Maxwell Plotkin
//COMP182 10/7/2017
//Stack

public class Stack extends LinkedList {
	//methods
	void push(int i) { setHead(new Node(i, head)); }
	void pushNode(Node n) { setHead(n); }

	public int pop() {
		int i = head.getInfo();
		setHead(head.getNext());
		return i;
	}//pop
	public Node popNode() {
		Node n = head;
		setHead(head.getNext());
		return n;
	}//popNode
}//stack
