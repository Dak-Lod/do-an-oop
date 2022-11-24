import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    // ManagerProduct managerProduct = new ManagerProduct();
    // ManagerOrder managerOrder = new ManagerOrder();
    // OrderDetail orderDetail = new OrderDetail(0, null, 0);

    public static void exit(){
        sc.close();
        System.out.println("Cảm ơn đã sử dụng chương trình!");
        System.exit(1);
    }

    public static void main(String[] args) {
        // MenuSelect mainMenu = new MenuSelect(2, new String[] {"Login", "Xem tình trạng hoá đơn"});
        // switch (mainMenu.showMenu()){
        //     case 1:
        //         LoginMenu.main(null);
        //         break;
        //     case 2:
        //         break;
        // };
        while (true) {
            int select = new MenuSelect(3, new String[] {
                "Quản lý sản phẩm",
                "Quản lý đơn hàng",
                "Thoát"
            }).showMenu();
    
            switch (select) {
                case 1:
                    ManagerProduct.main(args);
                    break;
                case 2:
                    ManagerOrder.main(args);
                    break;
                case 3:
                    exit();
                    return;
                case -1:
                    break;
            }

        }

    }

}