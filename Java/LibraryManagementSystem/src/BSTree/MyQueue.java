package BSTree;

import java.util.LinkedList;

public class MyQueue{
    LinkedList<Object> h;
    
    public MyQueue(){
        h = new LinkedList();
    }
    
    public boolean isEmpty(){
        return(h.isEmpty());
    }
    
    public void clear(){
        while(!isEmpty()){
            h.removeFirst();
        }
    }
    
    public void enqueue(Object x){
        h.add(x);
    }
    
    public Object dequeue() throws Exception{
        if(isEmpty()){
            return(null);
        }
        return(h.removeFirst()); 
    }
    
    public Object first() throws Exception{
        if(isEmpty()){
            return(null);
        }
        return(h.get(0));
    }
    
    public void traverse(){
        for(int i=0;i<h.size();i++){
            System.out.printf("%4d", h.get(i));
        }
        System.out.println();
    }
}