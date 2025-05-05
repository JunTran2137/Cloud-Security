package Controller;

import LinkedList.LinkedList;
import Model.Product;
import Ultility.Validation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProductManager {
    private final LinkedList<Product> pll = new LinkedList<>();

    public LinkedList<Product> getPll() {
        return pll;
    }
    
    public void loadProduct(){
        String fName = Validation.getString("Enter the file's name: ", "This is not a correct format file's name", ".*\\.txt$");
        
        try{
            int count=0;
            File f = new File(fName);
            Scanner sc = new Scanner(f);
            
            while (sc.hasNextLine()){
                String[] str = sc.nextLine().split("\\s*\\|\\s*");
                
                if(str.length!=5){
                    count++;
                    continue;
                }
                
                int quantity = Integer.parseInt(str[2]);
                int saled = Integer.parseInt(str[3]);
                
                if(quantity<saled || Validation.checkDuplicatePCode(pll, str[0])!=-1){
                    count++;
                }else{
                    pll.add(new Product(str[0], str[1], quantity, saled, Double.parseDouble(str[4])));
                }
            }
            
            System.out.println("Loaded successfully");
            System.out.println(count+" invalid product found");
        }catch (FileNotFoundException e1){
            System.out.println("File not found");
        }catch (NumberFormatException e2){
            System.out.println("Invalid data type in file");
        }  
    }
    
    public void addProduct(){
        String pCode;
        
        do{
            pCode = Validation.getString("Enter the product's code: ", "This is not a product code", "[Pp][0-9]{2}").toUpperCase();
            
            if(Validation.checkDuplicatePCode(pll, pCode)!=-1){
                System.out.println("Product's code existed");
                continue;
            }
            break;
        }while(true);
                    
        String pName = Validation.getString("Enter the product's name: ", "This is not a product name", "[\\w ]+");
        int quantity = Validation.getInt("Enter the product's quantity: ", 0, Integer.MAX_VALUE);
        int saled = Validation.getInt("Enter the product's saled: ", 0, quantity);
        double price = Validation.getDouble("Enter the product's price: ", 0, Double.MAX_VALUE);
        
        pll.add(new Product(pCode, pName, quantity, saled, price));
        System.out.println("Added succesfully");
    }
    
    public void displayProduct(){
        if(pll.isEmpty()){
            System.out.println("No product found");
            return;
        }
        
        System.out.println("Code | Pro_name | Quantity | Saled | Price | Value ");
        System.out.println("---------------------------------------------------");
        
        for(int i=0;i<pll.size();i++){
            System.out.println(pll.get(i));
        }
    }
    
    public void saveProduct(){
        if(pll.isEmpty()){
            System.out.println("No product found");
            return;
        }
        
        String str="";
        String fName = Validation.getString("Enter the file's name: ", "This is not a correct format file's name", ".*\\.txt$");
        
        try{
            File f = new File(fName);
            
            try (FileWriter fw = new FileWriter(f)) {
                for(int i=0;i<pll.size();i++){
                    str = str+pll.get(i).toString1()+"\n";    
                }
                
                fw.write(str.trim());
                System.out.println("Saved succesfully");
                fw.close();
            }
        } catch (IOException ex) {
            System.out.println("Couldn't write to file");
        }
    }
    
    public void searchProduct(){
        if(pll.isEmpty()){
            System.out.println("No product found");
            return;
        }
        
        String pCode = Validation.getString("Enter the product's code: ", "This is not a product code", "[Pp][0-9]{2}");
        
        if(Validation.checkDuplicatePCode(pll, pCode)==-1){
            System.out.println("Product's code not found");
        }else{
            System.out.println("Product's code found");
        }
    } 
    
    public void deleteProduct(){
        if(pll.isEmpty()){
            System.out.println("No product found");
            return;
        }
        
        String pCode = Validation.getString("Enter the product's code: ", "This is not a product code", "[Pp][0-9]{2}");
        int index = Validation.checkDuplicatePCode(pll, pCode);
        
        if(index==-1){
            System.out.println("Product's code not found");
        }else{
            pll.remove(index);
            System.out.println("Deleted succesfully");
        }
    }
    
    public void sortProduct(){
        if(pll.isEmpty()){
            System.out.println("No product found");
            return;
        }
        
        for(int i=0;i<pll.size()-1;i++){
            for(int j=i;j<pll.size();j++){
                if(pll.get(i).getpCode().compareToIgnoreCase(pll.get(j).getpCode())>0){
                    Product t = pll.get(i);
                    pll.set(i, pll.get(j));
                    pll.set(j, t);
                }
            }
        }
        
        System.out.println("Sorted succesfully");
    }
    
    public void addProductWithPosition(){
        String pCode;
        
        do{
            pCode = Validation.getString("Enter the product's code: ", "This is not a product code", "[Pp][0-9]{2}").toUpperCase();
            
            if(Validation.checkDuplicatePCode(pll, pCode)!=-1){
                System.out.println("Product's code existed");
                continue;
            }
            
            break;
        }while(true);
                    
        String pName = Validation.getString("Enter the product's name: ", "This is not a product name", "[\\w ]+");
        int quantity = Validation.getInt("Enter the product's quantity: ", 0, Integer.MAX_VALUE);
        int saled = Validation.getInt("Enter the product's saled: ", 0, quantity);
        double price = Validation.getDouble("Enter the product's price: ", 0, Double.MAX_VALUE);
        
        int i = Validation.getInt("Enter the position from 1 to "+(pll.size())+" to add: ", 1, pll.size());
        
        pll.add(i-1, new Product(pCode, pName, quantity, saled, price));
        System.out.println("Added succesfully");
    }
    
    public void deleteProductAfter(){
        if(pll.isEmpty()){
            System.out.println("No product found");
            return;
        }
        
        String pCode = Validation.getString("Enter the product's code: ", "This is not a product code", "[Pp][0-9]{2}");
        int index = Validation.checkDuplicatePCode(pll, pCode);
        
        if(index==-1){
            System.out.println("Product's code not found");
        }else{
            if(index+1<=pll.size()-1){
                pll.remove(index+1);
                System.out.println("Deleted succesfully");
            }else{
                System.out.println("Reached last product");
            }   
        }
    }
}
