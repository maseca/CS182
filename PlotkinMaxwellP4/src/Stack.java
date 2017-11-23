//Maxwell Plotkin COMP182
class Stack extends LinkedList {
	//methods
	void push(TNode i) { setHead(new Node(i, head)); }

	TNode pop() {
		TNode i = head.getInfo();
		setHead(head.getNext());
		return i;
	}

	TNode peek() { return head.getInfo(); }
}
