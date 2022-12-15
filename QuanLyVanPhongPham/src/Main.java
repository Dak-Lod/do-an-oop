import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ManagerProduct qlSanPham = new ManagerProduct();
    public static ManagerOrder qlHoaDon = new ManagerOrder();
    public static ManagerWareHouse qlWareHouse = new ManagerWareHouse();
    public static ManageAccount qlTaiKhoan = new ManageAccount();
    // public static ManagerAccount qlTaiKhoan = new ManagerAccount();
    // public static ManagerWareHouse qlKhoHang = new ManagerWareHouse();
    public static int role = -1;
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
        qlTaiKhoan.add(new Account("ad1", "admin", "admin", 0, "Trần", "Lộc", Date.createDateFromString("06/5/2003"), "0337961759"));
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
                "Đăng nhập quản trị",
                "Đăng nhập nhân viên",
                "Thoát"
            }).showMenu();

            if (select == -1) continue;

            if (select == 3) exit();

            String[] input = null;

            
            input = new MenuInput(new String[]{
                "Nhập tài khoản",
                "Nhập mật khẩu"
            }).showMenu();
            if (input == null) continue;
            boolean test = false;
            for (Account ele: qlTaiKhoan.getAccountList()){
                if (ele == null) break;
                if (ele.getUser().equals(input[0]) && ele.getPass().equals(input[1])
                    && (ele.getRole() == 0 || ele.getRole() == select - 1)){
                    System.out.println("Đăng nhập thành công! Chào mừng " + ele.getInfo().getName());
                    test = true;
                    break;
                }
            }
            if (!test){
                System.out.println("Tài khoản hoặc mật khẩu không tồn tại!");
                continue;
            }
            
            Main.role = select;

            if (select == 1) {
                select = new MenuSelect(new String[] {
                    "Quản lý tài khoản quản trị",
                    "Quản lý tài khoản nhân viên",
                    "Quản lý tài khoản khách hàng",
                    "Quản lý sản phẩm",
                    "Quản lý đơn hàng",
                    "Quản lý kho hàng",
                    "Quản lý tài khoản",
                    "Thoát"
                }).showMenu();
        
                switch (select) {
                    case 1:
                        qlTaiKhoan.main(args);
                        break;
                    case 2:
                        qlSanPham.main(args);
                        break;
                    case 3:
                        qlHoaDon.main(args);
                        break;
                    case 4:
                        qlWareHouse.main(args);
                        break;
                    case 5:
                        qlTaiKhoan.main(args);
                        break;
                    case 6:
                        exit();
                        return;
                    case -1:
                        break;
                }
    
            }
        }

    }

}