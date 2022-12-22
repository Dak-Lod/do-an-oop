import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ManagerProduct qlSanPham = new ManagerProduct();
    public static ManagerOrder qlHoaDon = new ManagerOrder();
    public static ManagerWareHouse qlWareHouse = new ManagerWareHouse();
    public static ManageAccount qlTaiKhoan = new ManageAccount();
    public static Account loginAccount = null;

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
        qlTaiKhoan.add(new Account("em1", "em", "em", 1, "Trần", "Lộc", Date.createDateFromString("06/5/2003"), "0337961759"));
        qlTaiKhoan.add(new Account("cus1", "cus", "cus", 2, "Trần", "Lộc", Date.createDateFromString("06/5/2003"), "0337961759"));


        while (true) {
            for (int i = 0; i < 73; i++)
                System.out.print("=");
            System.out.println();

            System.out.printf("|\t%-54s\t\t|\n","CHÀO MỪNG BẠN ĐẾN VỚI PHẦN MỀM QUẢN LÝ VĂN PHÒNG PHẨM!");
            
            for (int i = 0; i < 73; i++)
                System.out.print("=");
            System.out.println("");
            System.out.printf(" \t\t    %s    \t\t\t \n","Vui lòng đăng nhập để sử dụng!");
            System.out.println("");
            
            
            Scanner sc = new Scanner(System.in);
            System.out.printf("\t\t\t%-9s: ","Tài khoản");
            String user =  sc.nextLine();
            System.out.printf("\t\t\t%-9s: ","Mật khẩu");
            String pass =  sc.nextLine();
            
            System.out.println();

            // int select = new MenuSelect(new String[] {
            //     "Đăng nhập",
            //     "Thoát"
            // }).showMenu();

            // if (select == -1) continue;

            // if (select == 2) exit();

            if (Login(user, pass))
                AfterLogin();
        }

    }

    static boolean Login(String user, String pass){
        String[] input = {user, pass};
        // input = new MenuInput(new String[]{
        //     "Nhập tài khoản",
        //     "Nhập mật khẩu"
        // }).showMenu();
        // if (input == null) return false;
        for (Account ele: qlTaiKhoan.getAccountList()){
            if (ele == null) break;
            if (ele.getUser().equals(input[0]) && ele.getPass().equals(input[1])
            && (ele.getRole() == 0 || ele.getRole() == 1)){
                Main.role = ele.getRole();
                System.out.println("Đăng nhập thành công! Chào mừng " + ele.getInfo().getName());
                loginAccount = ele;
                return true;
            }
        }
        System.out.println("Tài khoản hoặc mật khẩu không tồn tại!");
        return false;
    }

    static void AfterLogin(){
        while (true){
            int select = new MenuSelect(new String[] {
                "Quản lý tài khoản",
                "Quản lý sản phẩm",
                "Quản lý đơn hàng",
                "Quay lại",
                "Thoát"
            }).showMenu();
    
            switch (select) {
                case 1:
                    qlTaiKhoan.main();
                    break;
                case 2:
                    qlSanPham.main();
                    break;
                case 3:
                    qlHoaDon.main();
                    break;
                case 4:
                    return;
                case 5:
                    exit();
                // case -1:
                //     break;
            }

        }
    }

}