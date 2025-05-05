package Model;

public class Customer {
    private String cCode;
    private String cusName;
    private String phone;

    public Customer() {
    }

    public Customer(String cCode, String cusName, String phone) {
        this.cCode = cCode;
        this.cusName = cusName;
        this.phone = phone;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString(){
        return String.format("%-5s| %-9s| %-9s", cCode, cusName, phone);
    }
}
