public class PlotkinGCD{

    public static void main(String[] args) {
        System.out.println(gcd(20,15));
    }//main

    public static int gcd(int x, int y){
        while(x != y){
            if(x > y)
                x = x - y;
            else
                y = y - x;
        }//while
        return x;
    }//gcd

}//plotkingcd
