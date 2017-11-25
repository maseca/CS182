//Maxwell Plotkin COMP182
public class TNode {
	//attributes
	Feet value;
	int height, quantity;
	TNode left, right;

	//constructor
	TNode(Feet i) { value = i; height = 1; quantity = 0;}
	TNode(Feet i, int q) { value = i; height = 1; quantity = q;}

	//method
	public String toString() { return value + "(" + quantity + ") ";}
	public String toStringVerbose() { return value + "(" + quantity + ")<" + (height-1) + "> ";}
}
