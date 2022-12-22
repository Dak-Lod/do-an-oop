import javax.xml.crypto.Data;

public class ManagerOrder extends Manager{
    
    private Order[] orderList = new Order[100];
    private OrderDetail[] orderDetailList = new OrderDetail[1000];
    private int orderDetailCount = 0;
    private int orderCount = 0;

    String file_url = "DSHD.txt";

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
    public void add(){
        int select;
        Account cus = null;
        Account emp = Main.loginAccount;
        String[] info = new MenuInput(new String[] {
            "Nhập mã khách hàng",
        }).showMenu();
        if (info == null) return;

        cus = Main.qlTaiKhoan.getAccountbyId(info[0], 0);

        if (cus == null){
            System.out.println("Không tìm thấy tài khoản khách hàng, bạn có muốn tạo mới hay không?");
            select = new MenuSelect(new String[] {
                "Tạo tài khoản khách hàng mới",
                "Nhập lại mã khách hàng"
            }).showMenu();
            switch (select){
                case 1:
                    Main.qlTaiKhoan.add();
                    break;
                case 2:
                    add();
                    return;
            }

        }
        
        info = new MenuInput(new String[] {
            "Nhập mã hoá đơn",
            "Nhập ngày tạo hoá đơn (dd/mm/yyyy)"
        }).showMenu();
        if (info == null) return; 

        if (getOrderById(info[0]) != null){
            System.out.println("Mã hoá đơn đã tồn tại!");
            return;
        }

        int index = -1;
        int[] qty = new int[100]; 
        Product[] prd = new Product[100]; 
        OrderDetail[] ord = new OrderDetail[100];
        while (true){
            try {
                String[] result = new MenuInput(new String[]{
                    "Nhập mã sản phẩm " + (index + 2),
                    "Nhập số lượng sản phẩm " + (index + 2)
                }).showMenu();
                if (result != null){
                    index ++;
                    prd[index] = Main.qlSanPham.getProductById(result[0]);
                    if (prd[index] == null){
                        System.out.println("Mã sản phẩm không tồn tại!");
                        index--;
                        continue;
                    }
                    qty[index] = Integer.parseInt(result[1]);
                    if (prd[index].getQty() < qty[index]){
                        System.out.println("Số lượng sản phẩm không đủ!");
                        index--;
                        continue;
                    }
                }else {
                    break;
                }

            }catch (Exception e){
                System.out.println(e);
                return;
            }
            
        }
        if (index == -1){
            System.out.println("Không thể tạo hoá đơn không có sản phẩm!");
            return;
        }
        for (int i = 0; i <= index; i++){
            ord[i] = new OrderDetail(info[0], prd[i], qty[i]);
            orderDetailList[orderDetailCount] = ord[i];
            orderDetailCount++;
        }
        
        add(info[0], cus, emp, index + 1, info[1], ord);
        System.out.println("Tạo hoá đơn thành công!\nThông tin hoá đơn:");
        orderList[orderCount - 1].printOrder();
        
    }

    public void add(String id, Account cus, Account emp, int qty, String date, OrderDetail[] ord ){
        orderCount++;
        orderList[orderCount - 1] = new Order(id, cus, emp, qty, Date.createDateFromString(date), ord);
        // this.orderList[orderCount - 1].updateOrder();
    }

    @Override
    public void show() {
        show(orderList);
    }
    
    public void show(Order[] ord){
        if (ord[0] == null) {
            System.out.println("Danh sách hoá đơn trống!");
            return;
        }

        System.out.printf("\t\t\t\t%s\t\t\t\t\n", "DANH SÁCH HOÁ ĐƠN");

        for (int i = 0; i < 95; i++)
            System.out.print("=");
        System.out.println();

        System.out.printf("|%-7s|%-7s|%-24s|%-24s|%-15s|%-11s|\n", "STT", "ID", "Tên khách mua", "Tên nhân viên bán", "Ngày mua", "Thành tiền");

        for (int i = 0; i < 95; i++)
            System.out.print("-");
        System.out.println();
        
        for (int i = 0; i < ord.length; i++){
            if (ord[i] == null) break;
            System.out.printf("|%-7s|%-7s|%-24s|%-24s|%-15s|%-11s|\n", i,ord[i].getId(), ord[i].getCus().getInfo().getName(), ord[i].getEmp().getInfo().getName(), ord[i].getDateCreated(), ord[i].getTotal());
        }

        for (int i = 0; i < 95; i++)
            System.out.print("=");
        System.out.println("\n");
    }

    public void edit() {

    }

    public void search() {
        
    }

    public void read() {
        String[] data_read = read(file_url);
        for (int i = 0; i < data_read.length; i++) {
            if (data_read[i] == null)
                continue;
            String[] data = data_read[i].split(",");

            if (data[17] == null || data.length < 20 + Integer.parseInt(data[17]) * 5){
                System.out.println("Thêm hoá đơn dòng " + (i + 1)
                + " không thành công! (Dòng dữ liệu sai)");
                continue;
            }

            if (getOrderById(data[0]) != null) {
                System.out.println("Thêm hoá đơn dòng " + (i + 1)
                        + " không thành công! (Mã hoá đơn bị trùng)");
                continue;
            }
            Account cus = new Account(data[1], data[2], data[3], Integer.parseInt(data[4]), data[5], data[6], Date.createDateFromString(data[7]), data[8]);
            Account emp = new Account(data[9], data[10], data[11], Integer.parseInt(data[12]), data[13], data[14], Date.createDateFromString(data[15]), data[16]);

            OrderDetail[] list = new OrderDetail[100];
            for (int j = 0; j < Integer.parseInt(data[17]); j++){
                Product tmp = new Product(data[20 + (j * 5)], data[20 + (j * 5) + 1], Float.parseFloat(data[20 + (j * 5) + 2]), data[20 + (j * 5) + 3], Integer.parseInt(data[20 + (j * 5) + 4]));
                list[j] = new OrderDetail(data[0], tmp, Integer.parseInt(data[20 + (j * 5) + 4]));
                orderDetailList[orderDetailCount] = list[j];
            }

            add(data[0], cus, emp, Integer.parseInt(data[17]), data[18], list);
            // orderList[orderCount - 1].printOrder();
        }
    }

    public void write() {
        write(file_url, orderListToStrings(orderList));
    }

    public void remove() {
        String[] info = new MenuInput(new String[] {
            "Nhập mã sản phẩm cần xoá"
        }).showMenu();

        if (info == null) return;

        for (int i = 0; i < orderCount; i++) {
            if (orderList[i].getId().equals(info[0].trim())) {
                System.out.println("Đã xoá hoá đơn " + orderList[i].getId());
                for (int x = i; x < orderCount - 1; x ++){
                    orderList[x] = orderList[x + 1];
                }
                orderList[orderCount - 1] = null;
                orderCount--;
                return;
            }
        }
        
        System.out.println("Không tìm thấy tài khoản");
    }

    public Order getOrderById(String id){
        for (Order ele: orderList){
            if (ele == null) break;
            if (ele.getId() == id.trim()){
                return ele;
            }
        }
        return null;
    }


    public String[] orderListToStrings(Order[] ordList){
        String[] str = new String[100];
        for (int i = 0; i < ordList.length; i++){
            if (ordList[i] == null) break;
            str[i] = ordList[i].toString();
        }
        return str;
    }

}
