//Maxwell Plotkin COMP182 12/9/2017
//Finds Greatest Common Denominator of 2 integers
class PlotkinGCD{
    //methods
    static int findGCD(int x, int y){
        if(x == 0 || y == 0){
            System.err.println("0 has no common denominator");
            System.exit(1);
        }//fi

        if(x < 0)
            x *= -1;

        if(y < 0)
            y *= -1;

        while(x != y){
            if(x > y)
                x = x - y;
            else
                y = y - x;
        }//while
        return x;
    }//findgcd
}//plotkingcd
