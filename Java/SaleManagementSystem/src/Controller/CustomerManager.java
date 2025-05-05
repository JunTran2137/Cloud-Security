package Controller;

import LinkedList.LinkedList;
import Model.Customer;
import Ultility.Validation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerManager {
    private final LinkedList<Customer> cll = new LinkedList<>();

    public LinkedList<Customer> getCll() {
        return cll;
    }

    public void loadCustomer(){
        String fName = Validation.getString("Enter the file's name: ", "This is not a correct format file's name", ".*\\.txt$");
        
        try{
            int count=0;
            File f = new File(fName);
            Scanner sc = new Scanner(f);
            
            while (sc.hasNextLine()){
                String[] str = sc.nextLine().split("\\s*\\|\\s*");
                
                if(str.length!=3){
                    count++;
                    continue;
                }
                
                if(!str[2].matches("\\s*\\d+\\s*") || Validation.checkDuplicateCCode(cll, str[0])!=-1){
                    count++;
                }else{
                    cll.add(new Customer(str[0], str[1], str[2]));
                }
            }
            
            System.out.println("Loaded successfully");
            System.out.println(count+" invalid customer found");
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        } 
    }
    
    public void addCustomer(){
        String cCode;
        
        do{
            cCode = Validation.getString("Enter the customer's code: ", "This is not a customer code", "[Cc][0-9]{2}").toUpperCase();
            
            if(Validation.checkDuplicateCCode(cll, cCode)!=-1){
                System.out.println("Customer's code existed");
                continue;
            }
            break;
        }while(true);
                    
        String cName = Validation.getString("Enter the customer's name: ", "This is not a customer name", "[\\w ]+");
        String phone = Validation.getString("Enter the customer's phone: ", "This is not a customer phone", "\\d+");
        
        cll.add(new Customer(cCode, cName, phone));
        System.out.println("Added succesfully");
    }
    
    public void displayCustomer(){
        if(cll.isEmpty()){
            System.out.println("No customer found");
            return;
        }
        
        System.out.println("Code | Cus_name | Phone ");
        System.out.println("------------------------");
        
        for(int i=0;i<cll.size();i++){
            System.out.println(cll.get(i));
        }
    }
    
    public void saveCustomer(){
        if(cll.isEmpty()){
            System.out.println("No customer found");
            return;
        }
        
        String str="";
        String fName = Validation.getString("Enter the file's name: ", "This is not a correct format file's name", ".*\\.txt$");
        
        try{
            File f = new File(fName);
            
            try (FileWriter fw = new FileWriter(f)) {
                for(int i=0;i<cll.size();i++){
                    str = str+cll.get(i).toString()+"\n";    
                }
                
                fw.write(str.trim());
                System.out.println("Saved succesfully");
                fw.close();
            }
        } catch (IOException ex) {
            System.out.println("Couldn't write to file");
        }
    }
    
    public void searchCustomer(){
        if(cll.isEmpty()){
            System.out.println("No customer found");
            return;
        }
        
        String cCode = Validation.getString("Enter the customer's code: ", "This is not a customer code", "[Cc][0-9]{2}");
        
        if(Validation.checkDuplicateCCode(cll, cCode)==-1){
            System.out.println("Customer's code not found");
        }else{
            System.out.println("Customer's code found");
        }
    } 
    
    public void deleteCustomer(){
        if(cll.isEmpty()){
            System.out.println("No customer found");
            return;
        }
        
        String cCode = Validation.getString("Enter the customer's code: ", "This is not a customer code", "[Cc][0-9]{2}");
        int index = Validation.checkDuplicateCCode(cll, cCode);
        
        if(index==-1){
            System.out.println("Customer's code not found");
        }else{
            cll.remove(index);
            System.out.println("Deleted succesfully");
        }
    }
}
