package Main;

import Controller.SaleManager;
import Ultility.Validation;
import View.Menu;

public class Main {
    public static void main(String[] args) {
        SaleManager sm = new SaleManager();
        int choice;
        int subChoice;
        
        do{
            Menu.displayMenu();
            choice=Validation.getInt("Enter your choice: ", 0, 3);
            
            switch (choice){
                case 1:
                    do{
                        System.out.println();
                        Menu.displayProductMenu();
                        subChoice=Validation.getInt("Enter your choice: ", 0, 9);
                        
                        switch (subChoice){
                            case 1:
                                sm.getPm().loadProduct();
                                break;
                            case 2:
                                sm.getPm().addProduct();
                                break;
                            case 3:
                                sm.getPm().displayProduct();
                                break;
                            case 4:
                                sm.getPm().saveProduct();
                                break;
                            case 5:
                                sm.getPm().searchProduct();
                                break;
                            case 6:
                                sm.getPm().deleteProduct();
                                break;
                            case 7:
                                sm.getPm().sortProduct();
                                break;
                            case 8:
                                sm.getPm().addProductWithPosition();
                                break;
                            case 9:
                                sm.getPm().deleteProductAfter();
                                break;
                        }
                    }while (subChoice!=0);
                    break;
                case 2:
                    do{
                        System.out.println();
                        Menu.displayCustomerMenu();
                        subChoice=Validation.getInt("Enter your choice: ", 0, 6);
                        
                        switch (subChoice){
                            case 1:
                                sm.getCm().loadCustomer();
                                break;
                            case 2:
                                sm.getCm().addCustomer();
                                break;
                            case 3:
                                sm.getCm().displayCustomer();
                                break;
                            case 4:
                                sm.getCm().saveCustomer();
                                break;
                            case 5:
                                sm.getCm().searchCustomer();
                                break;
                            case 6:
                                sm.getCm().deleteCustomer();
                                break;
                        }
                    }while (subChoice!=0);
                    break;
                case 3:
                    do{
                        System.out.println();
                        Menu.displayOrderMenu();
                        subChoice=Validation.getInt("Enter your choice: ", 0, 3);
                        
                        switch (subChoice){
                            case 1:
                                sm.getOm().addOrder(sm.getPm().getPll(), sm.getCm().getCll());
                                break;
                            case 2:
                                sm.getOm().displayOrder();
                                break;
                            case 3:
                                sm.getOm().sortOrder();
                                break;
                        }
                    }while (subChoice!=0);
                    break;
                default:
                    System.out.println("Good bye");
                    break;
            }
            System.out.println();
        }while(choice!=0);
    }
}
