import java.util.Scanner;

public class ManagerOrder implements ManageInter{
    
    Order[] orderList = new Order[100];
    OrderDetail[] orderDetailList = new OrderDetail[100];
    
    static int count = 0;


    public void add(){
        String[] info = new MenuInput(2, new String[] {
            "Nhập mã khách hàng",
            "Nhập mã nhân viên",
        }).showMenu();
        while (true){
            Scanner sc = new Scanner(System.in);
            
            sc.close();
        }
    }
    


    public static void main(String[] args) {
        int select = new MenuSelect( 8, new String[] {
            "Thêm hoá đơn",
            "Tìm kiếm hoá đơn",
            "Sửa hoá đơn",
            "Xoá hoá đơn",
            "Đọc",
            "Ghi",
            "Quay lại",
            "Thoát"
        }).showMethod();

        switch (select){
            case 0:

        }

    }


}
