public class Test {
    public static void main(String[] args){
        SBTree sbTree = new SBTree();

        sbTree.insert(FeetInches.parseFtIn("12'"), 20);
        sbTree.insert(FeetInches.parseFtIn("12'0\""), 20);
        sbTree.insert(FeetInches.parseFtIn("15ft"), 20);

        System.out.println(sbTree.toPostOrder());

        Lumber lumber = new Lumber();

        lumber.lumberFactory("2x4 12'(180)");
    }
}
