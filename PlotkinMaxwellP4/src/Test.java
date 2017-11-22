public class Test {
    public static void main(String[] args){
        Lumber lumber = new Lumber();

        lumber.lumberFactory("2x4 12'(180) 15ft3in(200) 3 3/4'(10)");

        System.out.println(lumber.matrix[0][1].find(FeetInches.parseFtIn("12'")));
        lumber.sellLumber(0,1,FeetInches.parseFtIn("12'"),80);
        System.out.println(lumber.matrix[0][1].find(FeetInches.parseFtIn("12'")));
    }
}
