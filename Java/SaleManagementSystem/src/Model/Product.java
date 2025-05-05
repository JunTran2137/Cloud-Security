package Model;

public class Product {
    private String pCode;
    private String proName;
    private int quantity;
    private int saled;
    private double price;

    public Product() {
    }

    public Product(String pCode, String proName, int quantity, int saled, double price) {
        this.pCode = pCode;
        this.proName = proName;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return String.format("%-5s| %-9s| %-9d| %-6d| %-6.1f| %-6.1f", pCode, proName, quantity, saled, price, price*saled);
    }
    
    public String toString1(){
        return String.format("%-5s| %-9s| %-9d| %-6d| %-6.1f", pCode, proName, quantity, saled, price);
    }
}
