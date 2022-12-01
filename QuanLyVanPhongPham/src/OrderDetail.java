public class OrderDetail {
    private String orderId; //id hoá đơn đã mua
    private Product prd; 
    private int qty; //số lượng mặt hàng


    public OrderDetail(String orderId, Product prd, int qty) {
        this.orderId = orderId;
        this.prd = prd;
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

    public Product getprd() {
        return prd;
    }


    public void setprd(Product prd) {
        this.prd = prd;
    } 



}
