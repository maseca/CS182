public class FeetInches {
    private int feet;
    private Fraction inches;

    private FeetInches(int ft, Fraction in){
        feet = ft;
        inches = in;
    }

    static FeetInches parseFtIn(String str){
        int ft = 0;
        Fraction in = new Fraction(0,1);
        String[] inAry = str.replaceAll("ft", "\'")
                .replaceAll("in","\"").trim().split(" ");

        if(inAry.length == 2){
            ft = Integer.parseInt(inAry[0]);
            in = Fraction.parse(inAry[1].substring(0, inAry[1].length() - 1));
        }else{
            if(inAry[0].charAt(inAry[0].length() - 1) == '"'){
                String[] parts = inAry[0].substring(0,inAry[0].length() - 1).split("'");
                ft = Integer.parseInt(parts[0]);
                ft += Integer.parseInt(parts[1]) / 12;
                in = new Fraction(Integer.parseInt(parts[1]) % 12, 12);
            }else{
                ft = Integer.parseInt(inAry[0].substring(0,inAry[0].length() - 1));
            }
        }

        return new FeetInches(ft, in);
    }

    boolean greaterThan(FeetInches fI){
        double a = this.feet * 12 + this.inches.num / this.inches.den;
        double b = fI.feet * 12 + fI.inches.num / fI.inches.den;

        return a > b;
    }

    boolean lessThan(FeetInches fI){
        double a = this.feet * 12 + this.inches.num / this.inches.den;
        double b = fI.feet * 12 + fI.inches.num / fI.inches.den;

        return a < b;
    }

    boolean equals(FeetInches fI){
        double a = this.feet * 12 + this.inches.num / this.inches.den;
        double b = fI.feet * 12 + fI.inches.num / fI.inches.den;

        return a == b;
    }

    public String toString(){
        String out = "" + feet;

        if(inches.num != 0)
            out += " " + inches;

        return out + "ft";
    }
}
