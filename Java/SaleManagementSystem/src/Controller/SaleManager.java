package Controller;

public class SaleManager {
    private final ProductManager pm;
    private final CustomerManager cm;
    private final OrderManager om;

    public SaleManager() {
        pm = new ProductManager();
        cm = new CustomerManager();
        om = new OrderManager();
    }

    public ProductManager getPm() {
        return pm;
    }

    public CustomerManager getCm() {
        return cm;
    }

    public OrderManager getOm() {
        return om;
    }
}
