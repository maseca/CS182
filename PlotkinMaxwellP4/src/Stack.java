//Maxwell Plotkin COMP182
public class Stack extends LinkedList {
	//methods
	void push(TNode i) { setHead(new Node(i, head)); }
	void pushNode(Node n) { setHead(n); }

	public TNode pop() {
		TNode i = head.getInfo();
		setHead(head.getNext());
		return i;
	}
	public Node popNode() {
		Node n = head;
		setHead(head.getNext());
		return n;
	}

	public TNode peek() { return head.getInfo(); }
}
