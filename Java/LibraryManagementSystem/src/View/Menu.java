package View;

public class Menu {
    public static void displayBookMenu(){
        System.out.println("1.1. Load data from file");
        System.out.println("1.2. Input & insert data");
        System.out.println("1.3. In-order traverse");
        System.out.println("1.4. Breadth-first traverse");
        System.out.println("1.5. In-order traverse to file");
        System.out.println("1.6. Search by bcode");
        System.out.println("1.7. Delete by bcode by copying");
        System.out.println("1.8. Simply balancing");
        System.out.println("1.9. Count number of books");
        System.out.println("0. Exit");
    }
    
    public static void displayReaderMenu(){
        System.out.println("2.1. Load data from file");
        System.out.println("2.2. Input & add to the end");
        System.out.println("2.3. Display data");
        System.out.println("2.4. Save reader list to file");
        System.out.println("2.5. Search by rcode");
        System.out.println("2.6. Delete by rcode");
        System.out.println("0. Exit");
    }
    
    public static void displayLendingMenu(){
        System.out.println("3.1. Input data");
        System.out.println("3.2. Display lending data");
        System.out.println("3.3. Sort by bcode + rcode");
        System.out.println("0. Exit");
    }
    
    public static void displayMenu(){
        System.out.println("1. Manage book");
        System.out.println("2. Manage reader");
        System.out.println("3. Manage lending");
        System.out.println("0. Exit");
    }
}
