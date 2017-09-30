//Maxwell Plotkin COMP182 10/7/2017
//Tests SortArray

public class Test {
	public static void main(String[] args) {
		SortArray sa1, sa2, sa3;
		int[] arr = {5, 44, 345, -432, 98, 2345};

		sa1 = new SortArray();
		sa1.bubble();
		System.out.println("sa1.bubble: " + sa1.toString());

		sa2 = new SortArray("1 2 1243 098 2345 1234 7345 -1854");
		sa2.insertion();
		System.out.println("sa2.insertion: " + sa2.toString());

		sa3 = new SortArray(arr);
		sa3.selection();
		System.out.println("sa3.selection: " + sa3.toString());
	}//main
}//Test
