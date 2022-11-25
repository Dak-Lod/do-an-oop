import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ManagerProduct dsSanPham = new ManagerProduct();
    public static ManagerOrder dsHoaDon = new ManagerOrder();

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
            int select = new MenuSelect(new String[] {
                "Quản lý sản phẩm",
                "Quản lý đơn hàng",
                "Thoát"
            }).showMenu();
    
            switch (select) {
                case 1:
                    dsSanPham.main(args);
                    break;
                case 2:
                    dsHoaDon.main(args);
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