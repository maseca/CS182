//Maxwell Plotkin
//COMP182 10/7/2017
//Project 2 Test

public class Test {
	public static void main(String args[]){
		StackPlusGarbage sk1 = new StackPlusGarbage();

		for (int i=0; i<8; i++){
			sk1.push(i*2);
		}//for
		printStack(sk1);

		for (int i=0; i<3; i++){
			System.out.println("pop: "+sk1.pop());
		}//for
		printStack(sk1);

		sk1.push(100); printStack(sk1);
		sk1.push(200); printStack(sk1);
		sk1.push(300); printStack(sk1);
		sk1.push(500); printStack(sk1);
	}//main

	private static void printStack(Stack s) { System.out.println("Stack: " + s); }
}
