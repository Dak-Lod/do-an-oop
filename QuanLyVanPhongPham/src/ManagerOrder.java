import java.util.Scanner;

public class ManagerOrder extends Manager{
    
    private Order[] orderList = new Order[100];
    private OrderDetail[] orderDetailList = new OrderDetail[100];
    
    private int orderCount = 0;

    @Override
    public void add(){
        String[] info = new MenuInput(new String[] {
            "Nhập mã khách hàng",
            "Nhập mã nhân viên",
            "Nhập ngày tạo hoá đơn (dd/mm/yyyy)"
        }).showMenu();
        // //Kiểm tra khách hàng và nhân viên
        // if (ManagerAccount.getAccountById(Integer.parseInt(info[0])) == null){
        //     System.out.println("Không tìm thấy khách hàng!");
        // }else {
        //     Account
        // }
        Account cus = null;
        Account emp = null;
        int index = 3;
        String input;
        int[] qty = new int[100]; 
        Product[] prd = new Product[100]; 
        OrderDetail[] ord = new OrderDetail[100];
        Main.qlSanPham.show();
        while (true){
            try {
                String[] result = new MenuInput(new String[]{
                    "Nhập mã sản phẩm"
                }).showMenu();
                
                if (result != null){
                    
                }else {
                    break;
                }

            }catch (Exception e){
                System.out.println(e);
            }
            
        }
        if (index - 3 == 0){
            System.out.println("Tạo hoá đơn thất bại!Thiếu sản phẩm");
            return;
        }
        for (int i = 0; i < index - 3; i++){
            ord[i] = new OrderDetail("OD" + Integer.toString(orderCount), prd[i], qty[i]);
        }
        
        this.orderCount++;
        this.orderList[orderCount - 1] = new Order("OD" + Integer.toString(orderCount), cus, emp, index - 3, Date.createDateFromString(info[2]), prd, ord);
        this.orderList[orderCount - 1].updateOrder();
        System.out.println("Tạo hoá đơn thành công!\nThông tin hoá đơn:");
        this.orderList[orderCount - 1].printOrder();

    }


    public void main() {
        while (true){
            int select = new MenuSelect(new String[] {
                "Danh sách hoá đơn",
                "Thêm hoá đơn",
                "Tìm kiếm hoá đơn",
                "Sửa hoá đơn",
                "Xoá hoá đơn",
                "Đọc",
                "Ghi",
                "Quay lại",
                "Thoát"
            }).showMenu();
            if (getMethod(select) == -1) return;
        }

    }



    @Override
    public void edit() {

    }



    @Override
    public void search() {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void read() {
        // TODO Auto-generated method stub
        // super.read();
    }


    @Override
    public void write() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }


}
