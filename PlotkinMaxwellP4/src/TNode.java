//Maxwell Plotkin COMP182
public class TNode {
	//attributes
	int value, height, quantity;
	TNode left, right;

	//constructor
	TNode(int i) { value = i; height = 1; quantity = 0;}
	TNode(int i, int q) { value = i; height = 1; quantity = q;}

	//method
	public String toString() { return value + "(" + (height-1) + ") ";}
}
