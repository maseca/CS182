public class Test {
	public static void main(String args[]){
		StackPlusGarbage sk1 = new StackPlusGarbage();

		//push 8 even numbers to stack
		for (int i=0; i<8; i++){
			sk1.push(i*2);
		}

		//print stack w/ garbage
		printStack(sk1);

		//pop 3 numbers
		for (int i=0; i<3; i++){
			System.out.println("pop: "+sk1.pop());
		}
		printStack(sk1);

		sk1.push(100); printStack(sk1);
		sk1.push(200); printStack(sk1);
		sk1.push(300); printStack(sk1);
		sk1.push(500); printStack(sk1);

	}

	private static void printStack(Stack s) { System.out.println("Stack: " + s); }
}
