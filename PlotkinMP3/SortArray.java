//Maxwell Plotkin COMP182 10/28/2017
//Sorts integer and fraction arrays

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
	//attributes
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

	SortArray(String s){ str = s.trim(); }//constructor

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

	void quick(){ quick(sA, 0, sA.length-1); }
	private void quick(int[] sA, int lowest, int highest){
		if(lowest < highest){
			int part = partition(sA, lowest, highest);
			quick(sA, lowest, part-1);
			quick(sA, part+1, highest);
		}//fi
	}//quick

	private int partition(int[] sA, int low, int high){
		int pivot = sA[high], small = low-1;
		for(int x = low; x < high; x++) {
			if (sA[x] <= pivot) {
				small++;
				swap(sA, x, small);
			}//fi
		}//end for
		swap(sA, small+1, high);
		return small+1;
	}//partition

	void quickFraction() {
		Fraction[] s = _sToFA(str);
		quick(s, 0, s.length - 1);
		for(Fraction fraction : s){
			System.out.print(fraction + " ");
		}
		System.out.println();
	}//quick fraction

	private void quick(Fraction[] arr, int lowest, int highest){
		if(lowest < highest){
			int part = partition(arr, lowest, highest);
			quick(arr, lowest, part-1);
			quick(arr, part+1, highest);
		}//fi
	}//quick

	private int partition(Fraction[] arr, int low, int high){
		Fraction pivot = arr[high];
		int small = low-1;
		for(int x = low; x < high; x++) {
			if (arr[x].isLessThan(pivot) || arr[x] == pivot) {
				small++;
				swap(arr, x, small);
			}//fi
		}//end for
		swap(arr, small+1, high);
		return small + 1;
	}//partition

	private void swap(int[] arr, int pos1, int pos2){
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	private void swap(Fraction[] arr, int pos1, int pos2){
		Fraction temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	static int[] _sToIA(String s){
		String[] ints = s.trim().split(" ");
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

	static Fraction[] _sToFA(String s) {
		String[] fractions = s.trim().split(" ");
		int len = fractions.length;

		Fraction[] arr = new Fraction[len];
		for(int i = 0; i < len; ++i) {
			try {
				arr[i] = Fraction.parse(fractions[i]);
			} catch (NumberFormatException nfe) {
				System.err.println("Failed to parse Fraction #" + i);
			}//catch
		}//for i

		return arr;
	}//s to Fa

}//SortArray
