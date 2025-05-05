package Main;

import Controller.LibraryManager;
import Ultility.Validation;
import View.Menu;

public class Main {
    public static void main(String[] args) {
        LibraryManager m = new LibraryManager();
        int choice;
        int subChoice;
        
        do{
            Menu.displayMenu();
            choice=Validation.getInt("Enter your choice: ", 0, 3);
            
            switch (choice){
                case 1:
                    do{
                        System.out.println();
                        Menu.displayBookMenu();
                        subChoice=Validation.getInt("Enter your choice: ", 0, 9);
                        
                        switch (subChoice){
                            case 1:
                                m.getBm().loadBook();
                                break;
                            case 2:
                                m.getBm().addBook();
                                break;
                            case 3:
                                m.getBm().displayBook();
                                break;
                            case 4:
                                m.getBm().displayBreadth();
                                break;
                            case 5:
                                m.getBm().saveBook();
                                break;
                            case 6:
                                m.getBm().searchBook();
                                break;
                            case 7:
                                m.getBm().deleteBook();
                                break;
                            case 8:
                                m.getBm().balanceBook();
                                break;
                            case 9:
                                m.getBm().countBook();
                                break;
                        }
                    }while (subChoice!=0);
                    break;
                case 2:
                    do{
                        System.out.println();
                        Menu.displayReaderMenu();
                        subChoice=Validation.getInt("Enter your choice: ", 0, 6);
                        
                        switch (subChoice){
                            case 1:
                                m.getRm().loadReader();
                                break;
                            case 2:
                                m.getRm().addReader();
                                break;
                            case 3:
                                m.getRm().displayReader();
                                break;
                            case 4:
                                m.getRm().saveReader();
                                break;
                            case 5:
                                m.getRm().searchReader();
                                break;
                            case 6:
                                m.getRm().deleteReader();
                                break;
                        }
                    }while (subChoice!=0);
                    break;
                case 3:
                    do{
                        System.out.println();
                        Menu.displayLendingMenu();
                        subChoice=Validation.getInt("Enter your choice: ", 0, 3);
                        
                        switch (subChoice){
                            case 1:
                                m.getLm().addLending(m.getBm().getBt(), m.getRm().getRll());
                                break;
                            case 2:
                                m.getLm().displayLending();
                                break;
                            case 3:
                                m.getLm().sortLending();
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
