public class Order {
    private String id;
    private Account cus; //Id khách hàng
    private Account emp; // Id nhân viên
    int qty; // Số lượng
    private Date dateCreated; // ngày tạo đơn hàng
    private float total; //Tổng tiền
    private OrderDetail[] detail;


    public Order(String id, Account cus, Account emp, int qty, Date dateCreated, OrderDetail[] detail) {
        this.id = id;
        this.cus = cus;
        this.emp = emp;
        this.qty = qty;
        this.dateCreated = dateCreated;
        this.detail = detail;
    }

    


    public String getId() {
        return id;
    }




    public void setId(String id) {
        this.id = id;
    }




    public Account getCus() {
        return cus;
    }




    public void setCus(Account cus) {
        this.cus = cus;
    }




    public Account getEmp() {
        return emp;
    }




    public void setEmp(Account emp) {
        this.emp = emp;
    }




    public int getQty() {
        return qty;
    }




    public void setQty(int qty) {
        this.qty = qty;
    }




    public Date getDateCreated() {
        return dateCreated;
    }




    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }




    public float getTotal() {
        return total;
    }




    public void setTotal(float total) {
        this.total = total;
    }




    public OrderDetail[] getDetail() {
        return detail;
    }




    public void setDetail(OrderDetail[] detail) {
        this.detail = detail;
    }




    public void updateOrder(){
        total = 0;
        for (int i = 0; i < qty; i++){
            total += this.detail[i].getprd().getPrice() * this.detail[i].getQty();
        }
    }
    
    public void printOrder(){
        System.out.printf("\t\t\t\t    %-8s    \t\t\t\t\n", "HOÁ ĐƠN");
        System.out.printf( "\t%s %-5s\n","Mã hoá đơn: ", id);
        System.out.println("\tNgày mua: " + this.dateCreated);
        System.out.printf("\t\t\t    %-20s    \t\t\t\n", "Danh sách sản phẩm mua");
        for (int i = 0; i < 95; i++)
            System.out.print("=");
        System.out.println();
        // System.out.println("Tên khách hàng: " + this.getcus().getUser());
        // System.out.println("Tên nhân viên bán hàng: " + this.getcus().getUser());
        
        System.out.printf("|%-7s|%-25s|%-14s|%-14s|%-14s|%-14s|\n", "Thứ tự", "Tên sản phẩm", "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền");
        for (int i = 0; i < 95; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < qty; i++){
            System.out.printf("|%-7s|%-25s|%-14s|%-14s|%-14s|%-14s|\n", i,this.detail[i].getprd().getProductName(),this.detail[i].getprd().getProductId(), detail[i].getQty(), this.detail[i].getprd().getPrice(), this.detail[i].getprd().getPrice() * this.detail[i].getQty() );
        }
        this.updateOrder();
        for (int i = 0; i < 95; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf( "\t\t\t\t\t\t\t\t\t%-31s\n","Tổng: " + this.total + "$");
        System.out.println("\n\n");
    }

    
    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < qty; i++)
            tmp += detail[i].toString() + ',';
        tmp = tmp.substring(0, tmp.length() - 1);
        
        return String.join(",", new String[] {
            id,
            cus.toString(),
            emp.toString(),
            Integer.toString(qty),
            dateCreated.toString(),
            Float.toString(total),
            tmp
        });
    }
    

}
