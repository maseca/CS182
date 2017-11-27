//Maxwell Plotkin COMP182 12/9/2017
//node class for sbt
public class TNode {
	//attributes
	Feet value;
	int height, quantity;
	TNode left, right;

	//constructors
	TNode(Feet i) { value = i; height = 1; quantity = 0;}
	TNode(Feet i, int q) { value = i; height = 1; quantity = q;}

	//methods
	public String toString() { return value + "(" + quantity + ") ";}
	public String toStringVerbose() { return value + "(" + quantity + ")<" + (height-1) + "> ";}
}//tnode
