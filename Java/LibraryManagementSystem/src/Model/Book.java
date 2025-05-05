package Model;

public class Book  implements Comparable<Book>{
    private String bCode;
    private String title;
    private int quantity;
    private int lended;
    private double price;

    public Book() {
    }

    public Book(String bCode, String title, int quantity, int lended, double price) {
        this.bCode = bCode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    } 
    
    @Override
    public String toString(){
        return String.format("%-5s| %-9s| %-9d| %-8d| %-6.1f| %-6.1f", bCode, title, quantity, lended, price, price*quantity);
    }
    
    public String toString1(){
        return String.format("%-5s| %-9s| %-9d| %-6.1f", bCode, title, quantity, price);
    }

    @Override
    public int compareTo(Book o) {
        return bCode.compareToIgnoreCase(o.getbCode());
    }
}
