//Maxwell Plotkin
//COMP182 10/7/2017
//Stack With Garbage Collection

public class StackPlusGarbage extends Stack {
	//attributes
	private Stack garbage = new Stack();

	//methods
	@Override
	public int pop() {
		int i = head.getInfo();
		setHead(head.getNext());
		garbage.push(i);
		return i;
	}//pop
	@Override
	public Node popNode() {
		Node n = head;
		setHead(head.getNext());
		garbage.pushNode(n);
		return n;
	}//popNode

	public int popGarbage() {
		int i = garbage.head.getInfo();
		garbage.setHead(garbage.head.getNext());
		return i;
	}//popGarbage
	public Node popNodeGarbage() {
		Node n = garbage.head;
		garbage.setHead(garbage.head.getNext());
		return n;
	}//popNodeGarbage

	@Override
	public String toString() { return super.toString() + "\nGarbage: " + garbage; }
}//stackPlusGarbage
