public class Lumber {
    private int dimX, dimY, length, quantity;

    private Lumber(int x, int y, int len, int q){
        dimX = x;
        dimY = y;
        length = len;
        quantity = q;
    }

    public static void lumberFactory(String str){
        int[] dims;
        int len, q;

        String out = "";
        String in = str.replaceAll("\\s{2,}", "").trim();
        String[] inAry = in.split(" ");

        dims = parseDims(inAry[0]);
    }

    private static int[] parseDims(String str){
        int[] out = new int[2];
        String[] strings = str.split("x");

        out[0] = Integer.parseInt(strings[0]);
        out[1] = Integer.parseInt(strings[1]);

        return out;
    }
}
