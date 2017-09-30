//Maxwell Plotkin COMP182 10/7/2017
//Tests SortArray

public class Test {
	public static void main(String[] args) {
		SortArray sa1, sa2, sa3;

		sa1 = new SortArray();
		System.out.println("sa1 before bubble sort: " + sa1.str);
		sa1.bubble();
		System.out.println("sa1 after sort: " + sa1);

		sa2 = new SortArray(sa1.str);
		System.out.println("sa2 before insertion sort: " + sa2.str);
		sa2.insertion();
		System.out.println("sa2 after sort: " + sa2);

		sa3 = new SortArray(SortArray._sToIA(sa1.str));
		System.out.println("sa3 before selection sort: " + sa3.str);
		sa3.selection();
		System.out.println("sa3 after sort: " + sa3);
	}//main
}//Test
