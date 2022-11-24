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
        System.out.printf("\t\t       %-8s       \t\t\n", "HOÁ ĐƠN");
        System.out.printf( "%s %05d\n","Mã hoá đơn: ", this.getId());
        System.out.println("Ngày mua: " + this.dateCreadted);
        System.out.printf("\t\t%-22s\t\t\n", "Danh sách sản phẩm mua");
        for (int i = 0; i < 54; i++)
            System.out.print("=");
        System.out.println();
        // System.out.println("Tên khách hàng: " + this.getcus().getUser());
        // System.out.println("Tên nhân viên bán hàng: " + this.getcus().getUser());
        
        System.out.printf("|%-7s|%-14s|%-14s|%-14s|\n", "Thứ tự", "Tên sản phẩm", "Mã sản phẩm", "Số lượng");
        for (int i = 0; i < this.getQty(); i++){
            System.out.printf("|%-7s|%-14s|%-14s|%-14s|\n", i,this.prd[i].getProductName(),this.prd[i].getProductId(), this.getDetail()[i].getqty());
        }
        for (int i = 0; i < 54; i++)
            System.out.print("=");
        System.out.println();
    }

    public static void showOrder(Order ord){
        System.out.printf("\t\t       %-8s       \t\t\n", "HOÁ ĐƠN");
        System.out.printf( "%s %05d\n","Mã hoá đơn: ", ord.getId());
        System.out.println("Ngày mua: " + ord.dateCreadted);
        System.out.printf("\t\t%-22s\t\t\n", "Danh sách sản phẩm mua");
        for (int i = 0; i < 54; i++)
            System.out.print("=");
        System.out.println();
        // System.out.println("Tên khách hàng: " + this.getcus().getUser());
        // System.out.println("Tên nhân viên bán hàng: " + this.getcus().getUser());
        
        System.out.printf("|%-7s|%-14s|%-14s|%-14s|\n", "Thứ tự", "Tên sản phẩm", "Mã sản phẩm", "Số lượng");
        for (int i = 0; i < ord.getQty(); i++){
            System.out.printf("|%-7s|%-14s|%-14s|%-14s|\n", i,ord.prd[i].getProductName(),ord.prd[i].getProductId(), ord.getDetail()[i].getqty());
        }
        for (int i = 0; i < 54; i++)
            System.out.print("=");
        System.out.println();
    }
    

    

}
