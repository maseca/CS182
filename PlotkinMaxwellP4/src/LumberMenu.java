import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LumberMenu {
    public static void main(String[] args){
        menu();
    }

    static void menu(){
        Scanner kb = new Scanner(System.in);
        Lumber lumber = new Lumber();
        char selection;

        do {
            System.out.println("\nLumber Tracking System:\n" +
                    "(P)rint total stock\n" +
                    "(L)oad from file\n" +
                    "(S)ave to file\n" +
                    "(E)nter new stock\n" +
                    "(R)ecord sale\n" +
                    "(Q)uit\n" +
                    "Please make a selection:");
            selection = kb.next().charAt(0);
            kb.nextLine();

            switch (selection){
                case 'p':
                case 'P':
                    printStock(lumber);
                    break;
                case 'l':
                case 'L':
                    loadFile(lumber);
                    break;
                case 's':
                case 'S':
                    saveFile(lumber);
                    break;
                case 'e':
                case 'E':
                    enterNew(lumber, kb);
                    break;
                case 'r':
                case 'R':
                    recordSale(lumber, kb);
                    break;
                case 'q':
                case 'Q':
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }while(selection != 'q' && selection != 'Q');

    }

    private static void printStock(Lumber lumber) {
        System.out.println(lumber);
        System.out.println("Stack contents: " + lumber.stack);
    }

    private static void loadFile(Lumber lumber) {
        try{
            Scanner inFile = new Scanner(new File("input.txt"));
            while (inFile.hasNextLine()){
                lumber.lumberFactory(inFile.nextLine());
            }
        }catch (FileNotFoundException e){
            System.err.println("File not found.");
        }
    }

    private static void saveFile(Lumber lumber) {
        try{
            PrintWriter outFile = new PrintWriter("output.txt");
            outFile.print(lumber);
            outFile.close();
        }catch(Exception e){
            System.err.println("Unable to write to file");
        }
    }

    private static void enterNew(Lumber lumber, Scanner kb) {
        System.out.println("Enter new lumber:");
        lumber.lumberFactory(kb.nextLine());
    }

    private static void recordSale(Lumber lumber, Scanner kb) {
        System.out.println("Enter sold lumber:");
        lumber.sellLumber(kb.nextLine());
    }
}
