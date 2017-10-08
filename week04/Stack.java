//Maxwell Plotkin COMP182
public class Stack extends LinkedList {
	//methods
	void push(int i) { setHead(new Node(i, head)); }
	void pushNode(Node n) { setHead(n); }

	public int pop() {
		int i = head.getInfo();
		setHead(head.getNext());
		return i;
	}
	public Node popNode() {
		Node n = head;
		setHead(head.getNext());
		return n;
	}
}
