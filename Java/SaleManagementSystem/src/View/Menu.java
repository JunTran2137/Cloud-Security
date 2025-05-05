package View;

public class Menu {
    public static void displayProductMenu(){
        System.out.println("1.1. Load data from file");
        System.out.println("1.2. Input & add to the end");
        System.out.println("1.3. Display data");
        System.out.println("1.4. Save product list to file");
        System.out.println("1.5. Search by pcode");
        System.out.println("1.6. Delete by pcode");
        System.out.println("1.7. Sort by pcode");
        System.out.println("1.8. Add after position k");
        System.out.println("1.9. Delete the node after the node having code = xCode");
        System.out.println("0. Exit");
    }
    
    public static void displayCustomerMenu(){
        System.out.println("2.1. Load data from file");
        System.out.println("2.2. Input & add to the end");
        System.out.println("2.3. Display data");
        System.out.println("2.4. Save customer list to file");
        System.out.println("2.5. Search by ccode");
        System.out.println("2.6. Delete by ccode");
        System.out.println("0. Exit");
    }
    
    public static void displayOrderMenu(){
        System.out.println("3.1. Input data");
        System.out.println("3.2. Display data with total value");
        System.out.println("3.3. Sort by pcode + ccode");
        System.out.println("0. Exit");
    }
    
    public static void displayMenu(){
        System.out.println("1. Manage product");
        System.out.println("2. Manage customer");
        System.out.println("3. Manage order");
        System.out.println("0. Exit");
    }
}
