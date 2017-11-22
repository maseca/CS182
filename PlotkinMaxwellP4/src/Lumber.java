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

    public static Lumber lumberFactory(String str){
        int[] dims;
        ArrayList<LengthQuantity> lQs;

        String out = "";
        String in = str.replaceAll("\\s{2,}", " ").trim();
        String dimStr = in.substring(0, in.indexOf(" ") + 1);

        dims = parseDims(dimStr);


        return new Lumber(dims[0], dims[1], new FeetInches(1,new Fraction(0,1)), 1);
    }

    private static int[] parseDims(String str){
        int[] out = new int[2];
        String[] strings = str.split("x");

        out[0] = Integer.parseInt(strings[0]);
        out[1] = Integer.parseInt(strings[1]);

        if (out[0] < 2 || out[0] > 6 || out[1] < 3 || out[1] > 12){
            System.err.println("Invalid dimensions");
            return null;
        }

        return out;
    }
}
