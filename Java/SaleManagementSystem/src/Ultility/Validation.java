package Ultility;

import LinkedList.LinkedList;
import Model.Customer;
import Model.Order;
import Model.Product;
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
    
    public static int checkDuplicatePCode(LinkedList<Product> pll, String pCode){
        for(int i=0;i<pll.size();i++){
            if(pCode.equalsIgnoreCase(pll.get(i).getpCode())){
                return i;
            }
        }
        return -1;
    }
    
    public static int checkDuplicateCCode(LinkedList<Customer> cll, String cCode){
        for(int i=0;i<cll.size();i++){
            if(cCode.equalsIgnoreCase(cll.get(i).getcCode())){
                return i;
            }
        }
        return -1;
    }
    
    public static int checkDuplicateOrder(LinkedList<Order> oll, String pCode, String cCode){
        for(int i=0;i<oll.size();i++){
            if(pCode.equalsIgnoreCase(oll.get(i).getpCode()) && cCode.equalsIgnoreCase(oll.get(i).getcCode())){
                return i;
            }
        }
        return -1;
    }
}
