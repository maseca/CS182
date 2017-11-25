public class Test {
    public static void main(String[] args){
        Lumber lumber = new Lumber();

        lumber.lumberFactory("2x4 12'(180) 15ft3in(200) 3 3/4'(10)");
        lumber.lumberFactory("2x3 12'(180) 15ft3in(200) 3 3/4'(10)");

        System.out.println(lumber.matrix[0][1]);
        lumber.sellLumber("2x4 12'(180) 15ft3in(200)");

        System.out.println(lumber.matrix[0][1]);
        System.out.println(lumber.stack[0][1]);

        lumber.lumberFactory("2x4 15'3\"(20)");
        System.out.println(lumber.matrix[0][1]);
        System.out.println(lumber.stack[0][1]);

        System.out.println(lumber);
    }
}
