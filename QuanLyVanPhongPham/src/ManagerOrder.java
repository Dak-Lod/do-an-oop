import java.util.Scanner;

public class ManagerOrder implements ManageInter{
    
    static Order[] orderList = new Order[100];
    static OrderDetail[] orderDetailList = new OrderDetail[100];
    
    static int orderCount = 0;

    
    public static void add(){
        String[] info = new MenuInput(3, new String[] {
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
        while (true){
            try {
                System.out.println("Nhập mã hàng hoá (nhập /ex để kết thúc nhập hàng)");
                input = Main.sc.nextLine();
                if (input.indexOf("/ex") < 0){
                    Product tmp = ManagerProduct.getProductById(Integer.parseInt(input));
                    if ( tmp == null){
                        System.out.println("Không tìm thấy sản phẩm!");
                        return;
                    }
                    prd[index - 3] = tmp;
                    System.out.println("Nhập số lượng");
                        qty[index - 3] = Main.sc.nextInt();
                        // Main.sc.nextLine();
                    index ++;
                
                }else {
                    break;
                }

            }catch (Exception e){
                System.out.println(e);
            }
            
        }

        ManagerOrder.orderCount++;
        for (int i = 0; i < index - 3; i++){
            ord[i] = new OrderDetail(orderCount, prd[i], qty[i]);
        }
        ManagerOrder.orderList[orderCount] = new Order(orderCount, cus, emp, index - 3, Date.createDateFromString(info[2]), prd, ord);
        System.out.println("Tạo hoá đơn thành công!\nThông tin hoá đơn:");
        ManagerOrder.orderList[orderCount].showOrder();

    }



    public static void main(String[] args) {
        MenuSelect menu = new MenuSelect( 8, new String[] {
            "Thêm hoá đơn",
            "Tìm kiếm hoá đơn",
            "Sửa hoá đơn",
            "Xoá hoá đơn",
            "Đọc",
            "Ghi",
            "Quay lại",
            "Thoát"
        });
        while (true){

            int select = menu.showMenu();
    
            switch (select){
                case 1:
                    add();
                    break;
                case 7:
                    return;
                case -1:
                    break;
            }
        }

    }



    
    public void edit() {
        // TODO Auto-generated method stub
        
    }



    
    public void delete() {
        // TODO Auto-generated method stub
        
    }



    
    public void search() {
        // TODO Auto-generated method stub
        
    }



    
    public void show() {
        // TODO Auto-generated method stub
        
    }


}
