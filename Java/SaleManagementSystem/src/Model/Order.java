package Model;

public class Order {
    private String pCode;
    private String cCode;
    private int quantity;

    public Order() {
    }

    public Order(String pCode, String cCode, int quantity) {
        this.pCode = pCode;
        this.cCode = cCode;
        this.quantity = quantity;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return String.format("%-6s| %-6s| %-9d", pCode, cCode, quantity);
    }
}
