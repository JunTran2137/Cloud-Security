package Controller;

import BSTree.BSTree;
import LinkedList.LinkedList;
import Model.Reader;
import Model.Lending;
import Model.Book;
import Ultility.Validation;

public class LendingManager {
    private final LinkedList<Lending> lll = new LinkedList<>();
    
    public void addLending(BSTree<Book> bt, LinkedList<Reader> rll){
        String bCode = Validation.getString("Enter the book's code: ", "This is not a book code", "[Bb][0-9]{2}").toUpperCase();
        String rCode = Validation.getString("Enter the reader's code: ", "This is not a reader code", "[Rr][0-9]{2}").toUpperCase();
        int state = Validation.getInt("Enter the lending's state: ", 0, 2); 
        
        if(Validation.checkDuplicateBCode(bt, bCode)==-1 || Validation.checkDuplicateRCode(rll, rCode)==-1){
            System.out.println("Invalid lending");
            return;
        }
        
        if(Validation.checkDuplicateLending(lll, bCode, rCode)!=-1 && lll.get(Validation.checkDuplicateLending(lll, bCode, rCode)).getState()==1){
            System.out.println("Invalid lending");
            return;
        }
        
        if(state==2){
            lll.add(new Lending(bCode, rCode, 2));
        }else{
            int index = Validation.checkDuplicateBCode(bt, bCode);
            int bQuantity=bt.get(index).getQuantity();
            int bLended=bt.get(index).getLended();

            if(bQuantity==bLended){
                lll.add(new Lending(bCode, rCode, 0));
            }else{
                lll.add(new Lending(bCode, rCode, 1));
                bt.get(index).setLended(bt.get(index).getLended()+1);
            }
        }
        
        System.out.println("Added succesfully");
    }
    
    public void displayLending(){
        if(lll.isEmpty()){
            System.out.println("No lending found");
            return;
        }
        
        System.out.println("bCode | rCode | State ");
        System.out.println("----------------------");
        
        for(int i=0;i<lll.size();i++){
            System.out.println(lll.get(i));
        }
    }
    
    public void sortLending(){
        if(lll.isEmpty()){
            System.out.println("No lending found");
            return;
        }
        
        for(int i=0;i<lll.size()-1;i++){
            for(int j=i;j<lll.size();j++){
                if(lll.get(i).getbCode().compareToIgnoreCase(lll.get(j).getbCode())>0
                    || (lll.get(i).getbCode().compareToIgnoreCase(lll.get(j).getbCode())==0 
                        && lll.get(i).getrCode().compareToIgnoreCase(lll.get(j).getrCode())>0)){
                    Lending t = lll.get(i);
                    lll.set(i, lll.get(j));
                    lll.set(j, t);
                }
            }
        }
        
        System.out.println("Sorted succesfully");
    }
}
