package Ultility;

import BSTree.BSTree;
import BSTree.BSTree.Node;
import Model.Reader;
import Model.Lending;
import Model.Book;
import LinkedList.LinkedList;
import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int num;

        System.out.print(msg);

        while (true) {
            try {
                num = Integer.parseInt(sc.nextLine().trim());

                if (num < min || num > max) {
                    throw new NumberFormatException();
                } 
                
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer between " + min + " and " + max);
                System.out.print("Enter again: ");
            }
        }

        return num;
    }

    public static String getString(String msg, String err, String regex) {
        String str;
        
        System.out.print(msg);
        
        while (true) {
            try {
                str = sc.nextLine().trim();

                if (str.isEmpty()) {
                    System.out.println("Input must be a non-empty string");
                    throw new Exception();
                }
                
                if (!str.matches(regex)) {
                    System.out.println(err);
                    throw new Exception();
                }
                
                break;
            } catch (Exception e) {
                System.out.print("Enter again: ");
            }
        }

        return str;
    }
    
     public static double getDouble(String msg, double min, double max) {
        double num;

        System.out.print(msg);

        while (true) {
            try {
                num =Double.parseDouble(sc.nextLine().trim());

                if (num < min || num > max) {
                    throw new NumberFormatException();
                } 
                
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be an double between " + min + " and " + max);
                System.out.print("Enter again: ");
            }
        }

        return num;
    }
    
    public static int checkDuplicateBCode(BSTree<Book> bt, String bCode){
        for(int i=0;i<bt.size();i++){
            if(bCode.equalsIgnoreCase(bt.get(i).getbCode())){
                return i;
            }
        }
        return -1;
    }
    
    public static int checkDuplicateRCode(LinkedList<Reader> rll, String rCode){
        for(int i=0;i<rll.size();i++){
            if(rCode.equalsIgnoreCase(rll.get(i).getrCode())){
                return i;
            }
        }
        return -1;
    }
    
    public static int checkDuplicateLending(LinkedList<Lending> lll, String bCode, String rCode){
        for(int i=0;i<lll.size();i++){
            if(bCode.equalsIgnoreCase(lll.get(i).getbCode()) && rCode.equalsIgnoreCase(lll.get(i).getrCode())){
                return i;
            }
        }
        return -1;
    }
}
