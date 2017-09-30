//Maxwell Plotkin COMP182 10/7/2017
//Sorts integer arrays
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
	String str;
	private static int[] sA;

	SortArray(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Input integers separated by spaces:");
		String in;

		try{
			in = sc.nextLine().trim();
		}catch(Exception e){
			System.err.println("No input detected.");
			in = "0";
		}//catch

		str = in;
	}//constructor

	SortArray(String s){
		str = s.trim();
	}//constructor

	SortArray(int[] array){
		str = Arrays.toString(array)
				.replace("[","")
				.replace(",","")
				.replace("]", "");
	}//constructor

	public String toString() { return Arrays.toString(sA); }//toString

	void bubble () {
		sA = _sToIA(str);
		int len = sA.length;

		for (int i = 0; i < len - 1; ++i) {
			for(int j = 1; j < len - i; ++j) {
				if (sA[j - 1] > sA[j]) {
					int temp = sA[j];
					sA[j] = sA[j - 1];
					sA[j - 1] = temp;
				}//fi
			}//for j
		}//for i
	}//bubble

	void insertion () {
		sA = _sToIA(str);
		int len = sA.length;

		for(int i = 1; i < len; ++i){
			for(int j = 0; j < i; ++j){
				if(sA[i] < sA[j]){
					int temp = sA[i];
					sA[i] = sA[j];
					sA[j] = temp;
				}//fi
			}//for j
		}//for i
	}//insertion

	void selection(){
		sA = _sToIA(str);
		int len = sA.length;

		for(int i = 0; i < len-1; i++){
			int index = i;

			for(int j = i+1; j < len; j++){
				if(sA[j] < sA[index])
					index = j;
			}//for j

			int num = sA[index];
			sA[index] = sA[i];
			sA[i] = num;
		}//for i
	}//selection

	static int[] _sToIA(String s){
		String[] ints = s.split(" ");
		int len = ints.length;

		int[] arr = new int[len];
		for(int i = 0; i < len; ++i){
			try{
				arr[i] = Integer.parseInt(ints[i]);
			}catch (NumberFormatException nfe){
				System.err.println("Failed to parse integer #" + i);
			}//catch
		}//for i

		return arr;
	}//s to ia
}//SortArray
