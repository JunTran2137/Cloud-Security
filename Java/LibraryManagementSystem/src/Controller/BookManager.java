package Controller;

import BSTree.BSTree;
import Model.Book;
import Ultility.Validation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookManager {
    private final BSTree<Book> bt = new BSTree<>();

    public BSTree<Book> getBt() {
        return bt;
    }
    
    public void loadBook(){
        String fName = Validation.getString("Enter the file's name: ", "This is not a correct format file's name", ".*\\.txt$");
        
        try{
            int count=0;
            File f = new File(fName);
            Scanner sc = new Scanner(f);
            
            while (sc.hasNextLine()){
                String[] str = sc.nextLine().split("\\s*\\|\\s*");
                
                if(str.length!=4){
                    count++;
                    continue;
                }
                
                int quantity = Integer.parseInt(str[2]);
                
                if(Validation.checkDuplicateBCode(bt, str[0])!=-1){
                    count++;
                }else{
                    bt.insert(new Book(str[0], str[1], quantity, 0, Double.parseDouble(str[3])));
                }
            }
            
            System.out.println("Loaded successfully");
            System.out.println(count+" invalid book found");
        }catch (FileNotFoundException e1){
            System.out.println("File not found");
        }catch (NumberFormatException e2){
            System.out.println("Invalid data type in file");
        }  
    }
    
    public void addBook(){
        String bCode;
        
        do{
            bCode = Validation.getString("Enter the book's code: ", "This is not a book code", "[Bb][0-9]{2}").toUpperCase();
            
            if(Validation.checkDuplicateBCode(bt, bCode)!=-1){
                System.out.println("Book's code existed");
                continue;
            }
            break;
        }while(true);
                    
        String pName = Validation.getString("Enter the book's name: ", "This is not a book name", "[\\w ]+");
        int quantity = Validation.getInt("Enter the book's quantity: ", 0, Integer.MAX_VALUE);
        int lended = Validation.getInt("Enter the book's lended: ", 0, quantity);
        double price = Validation.getDouble("Enter the book's price: ", 0, Double.MAX_VALUE);
        
        bt.insert(new Book(bCode, pName, quantity, lended, price));
        System.out.println("Added succesfully");
    }
    
    public void displayBook(){
        if(bt.isEmpty()){
            System.out.println("No book found");
            return;
        }
        
        System.out.println("Code | Name     | Quantity | Lended | Price | Value ");
        System.out.println("----------------------------------------------------");
        
        for(int i=0;i<bt.size();i++){
            System.out.println(bt.get(i));
        }
    }
    
    public void displayBreadth(){
        if(bt.isEmpty()){
            System.out.println("No book found");
            return;
        }
        
        System.out.println("Code | Pro_name | Quantity | Lended | Price | Value ");
        System.out.println("---------------------------------------------------");
        
        bt.breadth();
    }
    
    public void saveBook(){
        if(bt.isEmpty()){
            System.out.println("No book found");
            return;
        }
        
        String str="";
        String fName = Validation.getString("Enter the file's name: ", "This is not a correct format file's name", ".*\\.txt$");
        
        try{
            File f = new File(fName);
            
            try (FileWriter fw = new FileWriter(f)) {
                for(int i=0;i<bt.size();i++){
                    str = str+bt.get(i).toString1()+"\n";    
                }
                
                fw.write(str.trim());
                System.out.println("Saved succesfully");
                fw.close();
            }
        } catch (IOException ex) {
            System.out.println("Couldn't write to file");
        }
    }
    
    public void searchBook(){
        if(bt.isEmpty()){
            System.out.println("No book found");
            return;
        }
        
        String bCode = Validation.getString("Enter the book's code: ", "This is not a book code", "[Bb][0-9]{2}");
        
        if(Validation.checkDuplicateBCode(bt, bCode)==-1){
            System.out.println("Book's code not found");
        }else{
            System.out.println("Book's code found");
        }
    } 
    
    public void deleteBook(){
        if(bt.isEmpty()){
            System.out.println("No book found");
            return;
        }
        
        String bCode = Validation.getString("Enter the book's code: ", "This is not a book code", "[Bb][0-9]{2}");
        int index = Validation.checkDuplicateBCode(bt, bCode);
        
        if(index==-1){
            System.out.println("Book's code not found");
        }else{
            bt.deleteByCopy(bt.getRoot(),bt.get(index));
            System.out.println("Deleted succesfully");
        }
    }
    
    public void balanceBook(){
        if(bt.isEmpty()){
            System.out.println("No book found");
            return;
        }
        
        bt.balance();
        System.out.println("Tree balanced");
    }
    
    public void countBook(){
        if(bt.isEmpty()){
            System.out.println("No book found");
            return;
        }
        
        System.out.println("There are " + bt.size() + " books.");
    }
    
}
