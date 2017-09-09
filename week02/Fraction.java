//Maxwell Plotkin COMP182

public class Fraction{

    public int num, den;

    public Fraction(int n, int d){
		if(d == 0){
			System.out.println("Denominator can not be 0");
		    System.exit(1);
		}
		if(n == 0){
			this.num = 0;
			this.den = 1;
		} else {
			int gcd;
			int sign = 1;

			if (n < 0 && d < 0) {
				n *= -1;
				d *= -1;
			} else if (n < 0) {
				n *= -1;
				sign = -1;
			} else if (d < 0) {
				d *= -1;
				sign = -1;
			}

			do {
				gcd = PlotkinGCD.findGCD(n, d);
				n /= gcd;
				d /= gcd;
			} while (gcd != 1);

			this.num = n * sign;
			this.den = d;
		}//else
    }//constructor

    public String display(){
        return this.num + "/" + this.den;
    }//display
}//fraction
