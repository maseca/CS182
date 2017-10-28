//Maxwell Plotkin COMP182

public class Fraction{
	//properties
    private int num, den;

    private Fraction(int n, int d){
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

    public String toString(){ return this.num + "/" + this.den; }//toString

	boolean isLessThan(Fraction comp) {
    	int num1 = this.num * comp.den;
    	int num2 = this.den * comp.num;

    	return num1 < num2;
	}//is less than

	static Fraction parse(String s){
		int n, d;
		n = d = 1;

    	String[] strings = s.split("/");

    	if (strings.length > 0)
    		n = Integer.parseInt(strings[0]);

    	if(strings.length == 2)
		    d = Integer.parseInt(strings[1]);

    	return new Fraction(n, d);
	}//parse
}//fraction
