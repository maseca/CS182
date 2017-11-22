import java.util.ArrayList;

public class Lumber {
    SBTree[][] matrix = new SBTree[5][10]; //2..6 X 3..12

    private class LengthQuantity{
        FeetInches length;
        int quantity;
    }

    void lumberFactory(String str){
        int[] dims;
        ArrayList<LengthQuantity> lQs;

        String out = "";
        String in = str.replaceAll("\\s{2,}", " ").trim();
        String dimStr = in.substring(0, in.indexOf(" "));
        String lQStr = in.substring(in.indexOf(" ")+1, in.length());

        dims = parseDims(dimStr);
        if(dims == null) return;

        dims[0] -= 2;
        dims[1] -= 3;
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
