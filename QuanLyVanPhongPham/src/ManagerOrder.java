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
        while (true){
            if (orderCount <= 0) {
                System.out.println("Danh sách sản phẩm trống! Không thể sửa sản phẩm!");
                return;
            }
            String[] info = new MenuInput(new String[] {
                "Nhập mã hoá đơn cần sửa"
            }).showMenu();
    
            if (info == null) return;
            
            for (int i = 0; i < orderCount; i++){
                System.out.println("Test");
                if (orderList[i].getId().equals(info[0].trim())){
                    
                    while (true){
                        int select = new MenuSelect(new String[] {
                            "Thay đổi mã hoá đơn",
                            "Thay đổi khách hàng",
                            "Thay đổi nhân viên bán",
                            "Quay lại"
                            }).showMenu();
                            
                            MenuInput[] infoChange = new MenuInput[10];
                            infoChange[0] = new MenuInput(new String[] {
                                "Mã cũ: " + orderList[i].getId() + "\nMã mới"
                            });
                            
                            infoChange[1] = new MenuInput(new String[] {
                                "Tên khách cũ: " + orderList[i].getCus().getInfo().getName().toString() + "\nMã khách mới"
                            });

                            infoChange[2] = new MenuInput(new String[] {
                                "Tên nhân viên cũ: " + orderList[i].getCus().getInfo().getName().toString() + "\nMã nhân viên mới"
                            });
            
                            // infoChange[3] = new MenuInput(new String[] {
                            //     "Danh sách sản phẩm cũ: " + orderList[i].getProductId() + "\nGiá mới"
                            // });
            
                            // infoChange[3] = new MenuInput(new String[] {
                            //     "Mô tả cũ: " + orderList[i].getProductId() + "\nMô tả mới"
                            // });
            
                            String strChange;
                            switch (select){
                                case 1:
                                    strChange = infoChange[0].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        if (getOrderById(strChange) != null){
                                            System.out.println("Mã mới bị trùng! Không thể đổi mã mới");
                                        }else {
                                            orderList[i].setId(strChange);
                                            System.out.println("Đổi mã sản phẩm thành công!");
                                            orderList[i].printOrder();
                                        }
                                        break;
                                    }
                                    System.out.println("Mã hoá đơn không được trống!");
                                    break;
                                case 2:
                                    strChange = infoChange[1].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        Account find = Main.qlTaiKhoan.getAccountbyId(strChange, 1);
                                        if (find == null){
                                            System.out.println("Mã khách hàng không tồn tại!");
                                            break;
                                        }
                                        orderList[i].setCus(find);
                                        System.out.println("Đổi khách hàng thành công!");
                                    }else {
                                        System.out.println("Khách hàng không được trống!");
                                    }
                                    break;
                                
                                case 3:
                                strChange = infoChange[1].showMenu()[0];
                                if (!strChange.trim().equals("")){
                                    Account find = Main.qlTaiKhoan.getAccountbyId(strChange, 0);
                                    if (find == null){
                                        System.out.println("Mã nhân viên không tồn tại!");
                                        break;
                                    }
                                    orderList[i].setCus(find);
                                    System.out.println("Đổi nhân viên thành công!");
                                }else {
                                    System.out.println("Nhân viên không được trống!");
                                }
                                break;
                            
                                case 4:
                                    return;
            
                            }
                        }
                        
                    }else {
                        break;

                    }

            }
            System.out.println("Không tìm thấy sản phẩm");

        }
    }

    public void search() {
        if (orderCount == 0){
            System.out.println("Danh sách sản phẩm trống, không thể tìm kiếm!");
            return;
        }
        while (true){
            int select = new MenuSelect(new String[] {
                "Tìm kiếm theo mã",
                "Tìm kiếm theo tên khách hàng",
                "Tìm kiếm theo tên người bán",
                "Tìm kiếm theo giá tiền",
                "Quay lại"
            }).showMenu();
    
            String[] data;
            Order[] result = null;
            switch (select){
                case 1: 
                    data = new MenuInput(new String[] {
                        "Nhập mã"
                    }).showMenu();
                    Order tmp = getOrderById(data[0]);
                    if (tmp != null){
                        result = new Order[1];
                        result[0] = tmp;
                        result[0].printOrder();
                    }else 
                        System.out.println("Không tìm thấy hoá đơn!");
                    break;
                case 2: 
                    data = new MenuInput(new String[] {
                        "Nhập tên khách hàng"
                    }).showMenu();
                    result = getOderByNameCus(data[0]);
                    break;                    
                    
                case 3: 
                    data = new MenuInput(new String[] {
                        "Nhập tên nhân viên bán"
                    }).showMenu();
                    result = getOderByNameEmp(data[0]);
                    break; 

                case 4: 
                    data = new MenuInput(new String[] {
                        "Nhập giá thấp nhất",
                        "Nhập giá lớn nhất"
                    }).showMenu();
                    result = getOrderByPrice(data[0], data[1]);
                    continue;
                case 5:
                    return;
            }  
        }
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

    public Order[] getOderByNameCus(String name){
        Order[] result = new Order[100];
        int index = -1;
        for (int i = 0; i < orderCount; i++) {
            if (orderList[i] == null) continue;
            if (orderList[i].getCus().getInfo().getName().toString().toLowerCase().indexOf(name.toLowerCase()) > -1 || 
            orderList[i].getCus().getInfo().getName().toString().toLowerCase().indexOf(Main.removeAccents(name.toLowerCase())) > -1){
                index ++;
                result[index] = orderList[i];
            }
        }  
        if (index > -1){
            System.out.println("Đã tìm thấy " + (index + 1) + " hoá đơn");
            // for (Product item : result){
            //     if (item == null) break;
            //     item.printProduct();
            // }
            this.show(result);
        }else {
            System.out.println("Không tìm thấy hoá đơn!");
            return null;
        }
        return result;
    }

    public Order[] getOderByNameEmp(String name){
        Order[] result = new Order[100];
        int index = -1;
        for (int i = 0; i < orderCount; i++) {
            if (orderList[i] == null) continue;
            if (orderList[i].getEmp().getInfo().getName().toString().toLowerCase().indexOf(name.toLowerCase()) > -1 || 
            orderList[i].getEmp().getInfo().getName().toString().toLowerCase().indexOf(Main.removeAccents(name.toLowerCase())) > -1){
                index ++;
                result[index] = orderList[i];
            }
        }  
        if (index > -1){
            System.out.println("Đã tìm thấy " + (index + 1) + " hoá đơn");
            // for (Product item : result){
            //     if (item == null) break;
            //     item.printProduct();
            // }
            this.show(result);
        }else {
            System.out.println("Không tìm thấy hoá đơn!");
            return null;
        }
        return result;
    }

    public Order[] getOrderByPrice(String min, String max){
        if (Float.parseFloat(min) < 0 || Float.parseFloat(max) < 0){
            System.out.println();
            return null;
        }
        if (min.trim() == "")
            min = "-1";
        else if (Float.parseFloat(min) < 0){
            System.out.println("Thành tiền không được âm");
            return null;
        }
        if (max.trim() == "")
            max = "-1";
        else if (Float.parseFloat(max) < 0){
            System.out.println("Thành tiền không được âm");
            return null;
        }
        return getOrderByPrice(Float.parseFloat(min), Float.parseFloat(max));
    }

    public Order[] getOrderByPrice(float min, float max){
        Order[] result = new Order[100];
        int index = -1;
        for (int i = 0; i < orderCount; i++) {
            if (orderList[i] == null) continue;
            if (min == -1 || orderList[i].getTotal() >= min)
            if (max == -1 || orderList[i].getTotal() <= max){
                index++;
                result[index] = orderList[i];
            }
        }  
        if (index > -1){
            System.out.println("Đã tìm thấy " + (index + 1) + " sản phẩm");
            // for (Product item : result){
            //     if (item == null) break;
            //     item.printProduct();
            // }
            this.show(result);
        }else {
            System.out.println("Không tìm thấy sản phẩm!");
            return null;
        }
        return result;
    }

}
