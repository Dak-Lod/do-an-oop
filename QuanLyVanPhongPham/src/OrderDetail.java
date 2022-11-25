public class OrderDetail {
    private String orderId; //id hoá đơn đã mua
    private Product pdt; 
    private int qty; //số lượng mặt hàng


    public OrderDetail(String orderId, Product pdt, int qty) {
        this.orderId = orderId;
        this.pdt = pdt;
        this.qty = qty;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Product getPdt() {
        return pdt;
    }


    public void setPdt(Product pdt) {
        this.pdt = pdt;
    } 



}
