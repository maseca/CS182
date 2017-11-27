//Maxwell Plotkin COMP182 12/9/2017
//Class for lumber inventory management

import java.util.ArrayList;

class Lumber {
    //attributes
    private SBTree[][] matrix = new SBTree[5][10]; //2..6 X 3..12
    Stack stack = new Stack();

    //custom value object class
    private class LengthQuantity{
        //attributes
        Feet length;
        int quantity;

        //constructor
        LengthQuantity(Feet fI, int q){
            length = fI;
            quantity = q;
        }//lengthQuantity
    }//lengthQuantity

    //methods
    void lumberFactory(String str){
        String in = str.replaceAll("\\s{2,}", " ").trim();
        if(!in.contains(" ")) return;

        int[] dims = parseDims(in.substring(0, in.indexOf(" ")));
        if(dims == null) return;

        String lqStr = in.substring(in.indexOf(" ")+1, in.length());

        dims[0] -= 2;
        dims[1] -= 3;
        ArrayList<LengthQuantity> lQs = new ArrayList<>();
        String[] lqAry = lqStr.split("\\)");

        for(String lq : lqAry){
            String[] parts = lq.split("\\(");

            if(Integer.parseInt(parts[1]) > 0)
                lQs.add(new LengthQuantity(Feet.fromString(parts[0]), Integer.parseInt(parts[1])));
        }//for

        if(lQs.isEmpty()) return;

        if(matrix[dims[0]][dims[1]] == null)
            matrix[dims[0]][dims[1]] = new SBTree();

        for(LengthQuantity lq : lQs) {
            matrix[dims[0]][dims[1]].insert(lq.length, lq.quantity);

            if(stack.head != null && stack.peek().value.equals(lq.length))
                stack.pop();
        }//for
    }//lumberFactory

    private int[] parseDims(String str){
        int[] out = new int[2];
        String[] strings = str.split("x");

        out[0] = Integer.parseInt(strings[0]);
        out[1] = Integer.parseInt(strings[1]);

        if (out[0] < 2 || out[0] > 6 || out[1] < 3 || out[1] > 12){
            System.err.println("Invalid dimensions");
            return null;
        }//end

        return out;
    }//parseDims

    void sellLumber(String str){
        String in = str.replaceAll("\\s{2,}", " ").trim();
        if(!in.contains(" ")) return;

        int[] dims = parseDims(in.substring(0, in.indexOf(" ")));
        if(dims == null) return;

        String lqStr = in.substring(in.indexOf(" ")+1, in.length());

        dims[0] -= 2;
        dims[1] -= 3;
        ArrayList<LengthQuantity> lQs = new ArrayList<>();
        String[] lqAry = lqStr.split("\\)");

        for(String lq : lqAry){
            String[] parts = lq.split("\\(");

            lQs.add(new LengthQuantity(
                    Feet.fromString(parts[0]),
                    Integer.parseInt(parts[1])
            ));
        }//for

        if(lQs.isEmpty()) return;

        for(LengthQuantity lq : lQs)
            _sellLumber(dims[0],dims[1], lq.length, lq.quantity);
    }//sellLumber

    private void _sellLumber(int dimX, int dimY, Feet len, int q){
        if(matrix[dimX][dimY] == null) return;

        TNode tN = matrix[dimX][dimY].find(len);
        if(tN == null) return;

        if(tN.quantity >= q){
            tN.quantity -= q;
            if(tN.quantity == 0)
                remove(dimX, dimY, tN);
        }else{
            System.err.println("Trying to sell more lumber than is available");
        }//end
    }//_sellLumber

    private void remove(int dimX, int dimY, TNode tN) {
        if(stack == null)
            stack = new Stack();

        stack.push(new TNode(tN.value));
        matrix[dimX][dimY].delete(tN.value);

        if (matrix[dimX][dimY].isEmpty())
            matrix[dimX][dimY] = null;
    }//remove

    public String toString(){
        String out = "";

        for(int i = 0; i < 5; ++i){
            for(int j = 0; j < 10; ++j){
                if(matrix[i][j] != null)
                    out += (i+2) + "x" + (j+3) + "  " + matrix[i][j] + "\n";
            }//for j
        }//for i

        return out;
    }//toString
}//Lumber
