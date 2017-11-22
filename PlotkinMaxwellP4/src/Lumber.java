import java.util.ArrayList;

class Lumber {
    SBTree[][] matrix = new SBTree[5][10]; //2..6 X 3..12
    private Stack[][] stack = new Stack[5][10];

    private class LengthQuantity{
        FeetInches length;
        int quantity;

        LengthQuantity(FeetInches fI, int q){
            length = fI;
            quantity = q;
        }
    }

    void lumberFactory(String str){
        String in = str.replaceAll("\\s{2,}", " ").trim();
        int[] dims = parseDims(in.substring(0, in.indexOf(" ")));
        String lqStr = in.substring(in.indexOf(" ")+1, in.length());

        if(dims == null) return;

        dims[0] -= 2;
        dims[1] -= 3;

        ArrayList<LengthQuantity> lQs = new ArrayList<>();
        String[] lqAry = lqStr.split("\\)");
        for(String lq : lqAry){
            String[] parts = lq.split("\\(");

            lQs.add(new LengthQuantity(
                    FeetInches.parseFtIn(parts[0]),
                    Integer.parseInt(parts[1])
            ));
        }
        if(lQs.isEmpty()) return;

        if(matrix[dims[0]][dims[1]] == null)
            matrix[dims[0]][dims[1]] = new SBTree();

        for(LengthQuantity lq : lQs) {
            matrix[dims[0]][dims[1]].insert(lq.length, lq.quantity);
            if(stack[dims[0]][dims[1]] != null && stack[dims[0]][dims[1]].peek().value == lq.length)
                stack[dims[0]][dims[1]].pop();
        }
    }

    private int[] parseDims(String str){
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

    void sellLumber(int dimX, int dimY, FeetInches len, int q){
        if(matrix[dimX][dimY] == null)
            return;

        TNode tN = matrix[dimX][dimY].find(len);
        if(tN == null)
            return;

        if(tN.quantity >= q){
            tN.quantity -= q;
            if(tN.quantity == 0)
                remove(dimX, dimY, tN);
        }else{
            System.err.println("Trying to sell more lumber than is available");
        }
    }

    private void remove(int dimX, int dimY, TNode tN) {
        if(stack[dimX][dimY] == null)
            stack[dimX][dimY] = new Stack();

        stack[dimX][dimY].push(tN);
        matrix[dimX][dimY].delete(tN.value);
    }

}
