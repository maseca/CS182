public class PlotkinSwap {

    public static void main(String[] args) {
        int x = 0;
        int y = 1;

        System.out.println("Before Swap:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("After Swap:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }//main

}//plotkinswap