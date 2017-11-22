public class FeetInches {
    private int feet;
    private Fraction inches;

    private FeetInches(int ft, Fraction in){
        feet = ft;
        inches = in;
    }

    static FeetInches ftInFactory(String str){
        int ft = 0;
        Fraction in = new Fraction(0,1);
        String[] inAry = str.split(" ");

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

    public String toString(){
        String out = "" + feet;

        if(inches.num != 0)
            out += " " + inches;

        return out + "ft";
    }
}
