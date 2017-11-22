public class Test {
    public static void main(String[] args){
        FeetInches x, y, z;

        x = FeetInches.parseFtIn("10ft");
        y = FeetInches.parseFtIn("12ft18in");
        z = FeetInches.parseFtIn("10 7/8'");

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
