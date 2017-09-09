//Maxwell Plotkin COMP182
public class PlotkinGCD{

    public static void main(String[] args) {
        System.out.println(findGCD(20,15));
    }//main

    public static int findGCD(int x, int y){
        while(x != y){
            if(x > y)
                x = x - y;
            else
                y = y - x;
        }//while
        return x;
    }//findgcd

}//plotkingcd
