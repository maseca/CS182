public class Feet {
    private int feet;
    private Fraction partial;

    private Feet(int ft, Fraction partial){
        this.feet = ft;
        this.partial = partial;
    }

    static Feet fromString(String str){
        int ft = 0;
        Fraction part = new Fraction(0,1);
        String[] inAry = str.replaceAll("ft", "\'")
                .replaceAll("in","\"").trim().split(" ");

        if(inAry.length == 2){
            ft = Integer.parseInt(inAry[0]);
            part = Fraction.parse(inAry[1].substring(0, inAry[1].length() - 1));
        }else{
            if(inAry[0].charAt(inAry[0].length() - 1) == '"'){
                String[] parts = inAry[0].substring(0,inAry[0].length() - 1).split("'");
                ft = Integer.parseInt(parts[0]);
                ft += Integer.parseInt(parts[1]) / 12;
                part = new Fraction(Integer.parseInt(parts[1]) % 12, 12);
            }else{
                ft = Integer.parseInt(inAry[0].substring(0,inAry[0].length() - 1));
            }
        }

        return new Feet(ft, part);
    }

    boolean greaterThan(Feet fI){
        double a = this.feet * 12 + (double) this.partial.num / (double) this.partial.den;
        double b = fI.feet * 12 + (double) fI.partial.num / (double) fI.partial.den;

        return a > b;
    }

    boolean lessThan(Feet fI){
        double a = this.feet * 12 + (double) this.partial.num / (double) this.partial.den;
        double b = fI.feet * 12 + (double) fI.partial.num / (double) fI.partial.den;

        return a < b;
    }

    boolean equals(Feet fI){
        return (this.feet == fI.feet && this.partial == fI.partial);
    }

    public String toString(){
        String out = "" + feet;

        if(partial.num != 0)
            out += " " + partial;

        return out + "ft";
    }
}
