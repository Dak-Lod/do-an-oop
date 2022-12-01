import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ManagerProduct qlSanPham = new ManagerProduct();
    public static ManagerOrder qlHoaDon = new ManagerOrder();
    
    // public static ManagerAccount qlTaiKhoan = new ManagerAccount();
    // public static ManagerWareHouse qlKhoHang = new ManagerWareHouse();

    public static void exit(){
        sc.close();
        System.out.println("Cảm ơn đã sử dụng chương trình!");
        System.exit(1);
    }

    

    public static String removeAccents(String str) {
        String[] AccentsMap = {
          "aàảãáạăằẳẵắặâầẩẫấậ",
          "AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬ",
          "dđ", "DĐ",
          "eèẻẽéẹêềểễếệ",
          "EÈẺẼÉẸÊỀỂỄẾỆ",
          "iìỉĩíị",
          "IÌỈĨÍỊ",
          "oòỏõóọôồổỗốộơờởỡớợ",
          "OÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢ",
          "uùủũúụưừửữứự",
          "UÙỦŨÚỤƯỪỬỮỨỰ",
          "yỳỷỹýỵ",
          "YỲỶỸÝỴ"    
        };
        for (int i = 0; i < AccentsMap.length; i++) {
            str = str.replaceAll('[' + AccentsMap[i].substring(1) + ']', Character.toString(AccentsMap[i].charAt(0)));
        }
        return str;
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
                    qlSanPham.main(args);
                    break;
                case 2:
                    qlHoaDon.main(args);
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