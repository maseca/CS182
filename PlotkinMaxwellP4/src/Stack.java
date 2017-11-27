//Maxwell Plotkin COMP182
class Stack extends LinkedList {
	//methods
	void push(TNode i) { setHead(new Node(i, head)); }

	void pop() {
		TNode i = head.getInfo();
		setHead(head.getNext());
	}

	TNode peek() { return head.getInfo(); }
}
