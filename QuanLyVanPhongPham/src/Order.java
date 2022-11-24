import java.util.Scanner;

public class Order {
    private int id;
    private int idCus; //Id khách hàng
    private int idEmp; // Id nhân viên
    int qty; // Số lượng
    private Date dateCreadted; // ngày tạo đơn hàng
    private int total; //Tổng tiền
    private Product[] prd;
    private OrderDetail[] detail;


    public Order(int id, int idCus, int idEmp, int qty, Date dateCreadted, int total, Product[] prd, OrderDetail[] detail) {
        this.id = id;
        this.idCus = idCus;
        this.idEmp = idEmp;
        this.qty = qty;
        this.dateCreadted = dateCreadted;
        this.total = total;
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



    public int getIdCus() {
        return idCus;
    }


    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }


    public int getIdEmp() {
        return idEmp;
    }


    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
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


    public void update(){
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
    
    

    

}
