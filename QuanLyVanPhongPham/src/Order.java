import java.util.Scanner;

public class Order {
    private String id;
    private Account cus; //Id khách hàng
    private Account emp; // Id nhân viên
    int qty; // Số lượng
    private Date dateCreadted; // ngày tạo đơn hàng
    private float total; //Tổng tiền
    private Product[] prd;
    private OrderDetail[] detail;


    public Order(String id, Account cus, Account emp, int qty, Date dateCreadted, Product[] prd, OrderDetail[] detail) {
        this.id = id;
        this.cus = cus;
        this.emp = emp;
        this.qty = qty;
        this.dateCreadted = dateCreadted;
        this.prd = prd;
        this.detail = detail;
    }

    




    public String getId() {
        return id;
    }



    public int getQty() {
        return qty;
    }



    public float getTotal() {
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
        int index = 0;
        while (prd[index] != null)
            index ++;
        float sum = 0;
        for (int i = 0; i < qty; i++){
            sum += this.detail[i].getPdt().price * this.detail[i].getQty();
        }
        this.total = sum;
    }
    
    public void showOrder(){
        System.out.printf("\t\t\t\t    %-8s    \t\t\t\t\n", "HOÁ ĐƠN");
        System.out.printf( "%s %05d\n","Mã hoá đơn: ", this.getId());
        System.out.println("Ngày mua: " + this.dateCreadted);
        System.out.printf("\t\t\t    %-20s    \t\t\t\n", "Danh sách sản phẩm mua");
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
        // System.out.println("Tên khách hàng: " + this.getcus().getUser());
        // System.out.println("Tên nhân viên bán hàng: " + this.getcus().getUser());
        
        System.out.printf("|%-7s|%-14s|%-14s|%-14s|%-14s|%-14s|\n", "Thứ tự", "Tên sản phẩm", "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền");
        for (int i = 0; i < 84; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < this.getQty(); i++){
            System.out.printf("|%-7s|%-14s|%-14s|%-14s|%-14s|%-14s|\n", i,this.prd[i].getProductName(),this.prd[i].getProductId(), this.getDetail()[i].getQty(), this.prd[i].getPrice(), this.prd[i].getPrice() * this.detail[i].getQty() );
        }
        this.updateOrder();
        for (int i = 0; i < 84; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf( "\t\t\t\t\t\t\t\t\t%-20s\n","Tổng: " + this.total + "$");
        System.out.println("\n\n");
    }

    

    

}
