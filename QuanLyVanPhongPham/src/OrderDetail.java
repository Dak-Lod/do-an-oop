public class OrderDetail {
    private int orderId; //id hoá đơn đã mua
    private Product pdt; 
    private int qty; //số lượng mặt hàng


    public OrderDetail(int orderId, Product pdt, int qty) {
        this.orderId = orderId;
        this.pdt = pdt;
        this.qty = qty;
    }

    public int getId(){
        return orderId;
    }

    public int getqty() {
        return qty;
    }


    public void setqty(int qty) {
        this.qty = qty;
    }



    public Product getPdt() {
        return pdt;
    }


    public void setPdt(Product pdt) {
        this.pdt = pdt;
    } 



}
