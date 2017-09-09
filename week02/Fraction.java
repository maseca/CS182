//Maxwell Plotkin COMP182
public class Fraction{

    public int num, den;

    public Fraction(int n, int d){
        while (n != 1 && d % n == 0){
            d /= n;
            n /= n;
        }//while

        this.num = n;
        this.den = d;
    }//constructor

    public String display(){
        return this.num + "/" + this.den;
    }//display

}//fraction
