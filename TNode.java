//Maxwell Plotkin COMP182
public class TNode {
	//attributes
	int value, height;
	TNode left, right;

	//constructor
	TNode(int i) { value = i; height = 1; }

	//method
	public String toString() { return value + "(" + (height-1) + ") ";}
}
