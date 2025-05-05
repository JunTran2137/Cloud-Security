package Controller;

import LinkedList.LinkedList;
import Model.Reader;
import Ultility.Validation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReaderManager {
    private final LinkedList<Reader> rll = new LinkedList<>();

    public LinkedList<Reader> getRll() {
        return rll;
    }

    public void loadReader(){
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

                int bYear = Integer.parseInt(str[2].trim());
                
                if(bYear>2010 || bYear<1900 || Validation.checkDuplicateRCode(rll, str[0])!=-1){
                    count++;
                }else{
                    rll.add(new Reader(str[0], str[1], bYear));
                }
            }
            
            System.out.println("Loaded successfully");
            System.out.println(count+" invalid reader found");
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (NumberFormatException e){
            System.out.println("Invalid data type in file");
        }
    }
    
    public void addReader(){
        String rCode;
        
        do{
            rCode = Validation.getString("Enter the reader's code: ", "This is not a reader code", "[Rr][0-9]{2}").toUpperCase();
            
            if(Validation.checkDuplicateRCode(rll, rCode)!=-1){
                System.out.println("Reader's code existed");
                continue;
            }
            break;
        }while(true);
                    
        String name = Validation.getString("Enter the reader's name: ", "This is not a reader name", "[\\w ]+");
        int bYear = Validation.getInt("Enter the reader's birth year: ", 1900, 2010);
        
        rll.add(new Reader(rCode, name, bYear));
        System.out.println("Added succesfully");
    }
    
    public void displayReader(){
        if(rll.isEmpty()){
            System.out.println("No reader found");
            return;
        }
        
        System.out.println("Code | Name | BYear ");
        System.out.println("--------------------");
        
        for(int i=0;i<rll.size();i++){
            System.out.println(rll.get(i));
        }
    }
    
    public void saveReader(){
        if(rll.isEmpty()){
            System.out.println("No reader found");
            return;
        }
        
        String str="";
        String fName = Validation.getString("Enter the file's name: ", "This is not a correct format file's name", ".*\\.txt$");
        
        try{
            File f = new File(fName);
            
            try (FileWriter fw = new FileWriter(f)) {
                for(int i=0;i<rll.size();i++){
                    str = str+rll.get(i).toString()+"\n";    
                }
                
                fw.write(str.trim());
                System.out.println("Saved succesfully");
                fw.close();
            }
        } catch (IOException ex) {
            System.out.println("Couldn't write to file");
        }
    }
    
    public void searchReader(){
        if(rll.isEmpty()){
            System.out.println("No reader found");
            return;
        }
        
        String rCode = Validation.getString("Enter the reader's code: ", "This is not a reader code", "[Rr][0-9]{2}");
        
        if(Validation.checkDuplicateRCode(rll, rCode)==-1){
            System.out.println("Reader's code not found");
        }else{
            System.out.println("Reader's code found");
        }
    } 
    
    public void deleteReader(){
        if(rll.isEmpty()){
            System.out.println("No reader found");
            return;
        }
        
        String rCode = Validation.getString("Enter the reader's code: ", "This is not a reader code", "[Rr][0-9]{2}");
        int index = Validation.checkDuplicateRCode(rll, rCode);
        
        if(index==-1){
            System.out.println("Reader's code not found");
        }else{
            rll.remove(index);
            System.out.println("Deleted succesfully");
        }
    }
}
