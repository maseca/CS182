import java.util.ArrayList;

public class Lumber {
    private int dimX, dimY;
    private FeetInches length;

    private Lumber(int x, int y, FeetInches len, int q){
        dimX = x;
        dimY = y;
        length = len;
    }

    private class LengthQuantity{
        FeetInches length;
        int quantity;
    }

    public static void lumberFactory(String str){
        int[] dims;
        ArrayList<LengthQuantity> lQs;

        String out = "";
        String in = str.replaceAll("\\s{2,}", " ").trim();
        String[] inAry = in.split(" ");

        dims = parseDims(inAry[0]);
        if (dims[0] < 2 || dims[0] > 6 || dims[1] < 3 || dims[1] > 12) return;




    }

    private static int[] parseDims(String str){
        int[] out = new int[2];
        String[] strings = str.split("x");

        out[0] = Integer.parseInt(strings[0]);
        out[1] = Integer.parseInt(strings[1]);

        return out;
    }
}
