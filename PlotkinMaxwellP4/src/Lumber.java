import java.util.ArrayList;

class Lumber {
    SBTree[][] matrix = new SBTree[5][10]; //2..6 X 3..12

    private class LengthQuantity{
        FeetInches length;
        int quantity;

        LengthQuantity(FeetInches fI, int q){
            length = fI;
            quantity = q;
        }
    }

    void lumberFactory(String str){
        int[] dims;
        ArrayList<LengthQuantity> lQs = new ArrayList<>();

        String out = "";
        String in = str.replaceAll("\\s{2,}", " ").trim();
        String dimStr = in.substring(0, in.indexOf(" "));
        String lqStr = in.substring(in.indexOf(" ")+1, in.length());

        dims = parseDims(dimStr);
        if(dims == null) return;

        dims[0] -= 2;
        dims[1] -= 3;

        String[] lqAry = lqStr.split("\\)");
        for(String lq : lqAry){
            String[] parts = lq.split("\\(");

            if(!parts[0].equals("") && !parts[1].equals("")) {
                lQs.add(new LengthQuantity(
                        FeetInches.parseFtIn(parts[0]),
                        Integer.parseInt(parts[1])
                ));
            }
        }

        if(lQs.isEmpty()) return;

        if(matrix[dims[0]][dims[1]] == null)
            matrix[dims[0]][dims[1]] = new SBTree();

        for(LengthQuantity lq : lQs){
            matrix[dims[0]][dims[1]].insert(lq.length, lq.quantity);
        }
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
