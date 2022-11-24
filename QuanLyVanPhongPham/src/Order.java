import java.util.Scanner;

public class Order {
    private int id;
    private Account cus; //Id khách hàng
    private Account emp; // Id nhân viên
    int qty; // Số lượng
    private Date dateCreadted; // ngày tạo đơn hàng
    private int total; //Tổng tiền
    private Product[] prd;
    private OrderDetail[] detail;


    public Order(int id, Account cus, Account emp, int qty, Date dateCreadted, Product[] prd, OrderDetail[] detail) {
        this.id = id;
        this.cus = cus;
        this.emp = emp;
        this.qty = qty;
        this.dateCreadted = dateCreadted;
        this.prd = prd;
        this.detail = detail;
    }

    




    public int getId() {
        return id;
    }



    public int getQty() {
        return qty;
    }



    public int getTotal() {
        return total;
    }



    public Account getcus() {
        return cus;
    }


    public void setcus(Account cus) {
        this.cus = cus;
    }


    public Account getemp() {
        return emp;
    }


    public void setemp(Account emp) {
        this.emp = emp;
    }


    public Date getDateCreadted() {
        return dateCreadted;
    }


    public void setDateCreadted(Date dateCreadted) {
        this.dateCreadted = dateCreadted;
    }


    public Product[] getPrd() {
        return prd;
    }


    public void setPrd(Product[] prd) {
        this.prd = prd;
    }


    public OrderDetail[] getDetail() {
        return detail;
    }


    public void setDetail(OrderDetail[] detail) {
        this.detail = detail;
    }


    public void updateOrder(){
        int sum = 0;
        for (int i = 0; i < this.detail.length; i++){
            sum += this.detail[i].getqty();
        }
        this.qty = sum;
        sum = 0;
        for (int i = 0; i < this.detail.length; i++){
            sum += this.detail[i].getPdt().price * this.detail[i].getqty();
        }
    }
    
    public void showOrder(){
        System.out.println("Mã hoá đơn: " + this.getId());
        // System.out.println("Tên khách hàng: " + this.getcus().getUser());
        // System.out.println("Tên nhân viên bán hàng: " + this.getcus().getUser());

        System.out.printf("|%-15s|%-15s|%-15s|%-15s|\n", "Thứ tự", "Tên sản phẩm", "Mã sản phẩm", "Số lượng");
        for (int i = 0; i < this.getQty(); i++){
            System.out.printf("|%-15s|%-15s|%-15s|%-15s|\n", i,this.prd[i].getProductName(),this.prd[i].getProductId(), this.getDetail()[i].getqty());
        }
    }

    public static void showOrder(Order ord){
        Product[] prd = ord.getPrd();
        System.out.println("Mã hoá đơn: " + ord.getId());
        System.out.println("Tên khách hàng: " + ord.getcus().getUser());
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|", "Thứ tự", "Tên sản phẩm", "Mã sản phẩm", "Số lượng");
        for (int i = 0; i < ord.getQty(); i++){
            System.out.printf("|%-15s|%-15s|%-15s|%-15s|", i, prd[i].getProductName(),
                prd[i].getProductId(), ord.getDetail()[i].getqty()
            );
        }
    }
    

    

}
