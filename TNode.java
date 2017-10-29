//Maxwell Plotkin COMP182
public class TNode {
	//attributes
	int value, height;
	TNode left, right;

	//constructors
	TNode(int i) {
		value = i;
		height = 1;
	}

	int getValue() { return value; }
	public void setValue(int i) { value = i; }

	public String toString() { return value + "(" + (height-1) + ") ";}
}
