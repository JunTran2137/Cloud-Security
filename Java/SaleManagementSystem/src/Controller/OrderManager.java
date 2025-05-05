package Controller;

import LinkedList.LinkedList;
import Model.Customer;
import Model.Order;
import Model.Product;
import Ultility.Validation;

public class OrderManager {
    private final LinkedList<Order> oll = new LinkedList<>();
    
    public void addOrder(LinkedList<Product> pll, LinkedList<Customer> cll){
        String pCode = Validation.getString("Enter the product's code: ", "This is not a product code", "[Pp][0-9]{2}");
        String cCode = Validation.getString("Enter the customer's code: ", "This is not a customer code", "[Cc][0-9]{2}");
        
        if(Validation.checkDuplicatePCode(pll, pCode)==-1 || Validation.checkDuplicateCCode(cll, cCode)==-1){
            System.out.println("Invalid order");
            return;
        }
        
        if(Validation.checkDuplicateOrder(oll, pCode, cCode)!=-1){
            System.out.println("Duplicate order");
            return;
        }
        
        int index = Validation.checkDuplicatePCode(pll, pCode);
        int pQuantity=pll.get(index).getQuantity();
        int pSaled=pll.get(index).getSaled();
        
        if(pQuantity==pSaled){
            System.out.println("Product is exhausted");
            return;
        }
        
        int quantity = Validation.getInt("Enter the order's quantity: ", 0, pQuantity-pSaled);    
        oll.add(new Order(pCode, cCode, quantity));
        System.out.println("Added succesfully");
    }
    
    public void displayOrder(){
        if(oll.isEmpty()){
            System.out.println("No order found");
            return;
        }
        
        System.out.println("pCode | cCode | Quantity ");
        System.out.println("-------------------------");
        
        for(int i=0;i<oll.size();i++){
            System.out.println(oll.get(i));
        }
    }
    
    public void sortOrder(){
        if(oll.isEmpty()){
            System.out.println("No order found");
            return;
        }
        
        for(int i=0;i<oll.size()-1;i++){
            for(int j=i;j<oll.size();j++){
                if(oll.get(i).getpCode().compareToIgnoreCase(oll.get(j).getpCode())>0
                    || (oll.get(i).getpCode().compareToIgnoreCase(oll.get(j).getpCode())==0 
                        && oll.get(i).getcCode().compareToIgnoreCase(oll.get(j).getcCode())>0)){
                    Order t = oll.get(i);
                    oll.set(i, oll.get(j));
                    oll.set(j, t);
                }
            }
        }
        
        System.out.println("Sorted succesfully");
    }
}
