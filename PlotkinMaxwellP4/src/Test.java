public class Test {
    public static void main(String[] args){
        FeetInches x, y, z;

        x = FeetInches.ftInFactory("10'");
        y = FeetInches.ftInFactory("12'18\"");
        z = FeetInches.ftInFactory("10 7/8'");

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
