
public class ManagerWareHouse extends Manager{
    
    private WareHouse[] wareHouseList = new WareHouse[100];
    private Address[] addressList = new Address[100];
    private int wareHouseCount = 0;
    private int idCount = 0;

    private String file_url = "WareHouse.txt";
    
    public void main(String[] args) {
        while (true) {
            MenuSelect menu = new MenuSelect(new String[] {
                "Danh sách kho hàng",
                "Thêm kho hàng",
                "Tìm kiếm kho hàng",
                "Sửa kho hàng",
                "Xoá kho hàng",
                "Đọc",
                "Ghi",
                "Quay lại",
                "Thoát"
            });
            int select =  menu.showMenu();
            if (getMethod(select) == -1) return;
            
        }
    }
    
    @Override
    public void show() {
        show(wareHouseList);        
    }
    public void show(WareHouse[] wh) {
        if (wh[0] == null) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.printf("\t\t\t           %-21s           \t\t\t\n", "DANH SÁCH KHO HÀNG");
        for (int i = 0; i < 98; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf("|%-7s|%-7s|%-29s|%-29s|\n", "STT", "ID", "Tên kho hàng", "Địa chỉ kho hàng");
        for (int i = 0; i < 100; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < wh.length; i++){
            if (wh[i] == null) break;
            System.out.printf("|%-7s|%-7s|%-29s|%-29s|\n", (i + 1),wh[i].getWareHouseId(),wh[i].getWareHouseName(), wh[i].getWareHouseAdd());
        }
        for (int i = 0; i < 98; i++)
            System.out.print("=");
        System.out.println();
    }

    @Override
    public void add(){
        String[] info = new MenuInput(new String[] {
            "Nhập tên kho hàng",   
            "Nhập số địa chỉ",
            "Nhập đường",
            "Nhập quận",
            "Nhập thành phố"
        }).showMenu();
       
        if (info == null) return;
        wareHouseCount ++;
        idCount ++;
        String id = "WH" + Integer.toString(idCount);
        
        wareHouseList[wareHouseCount - 1] = new WareHouse(id, info[0], info[1], info[2], info[3], info[4]);     
        System.out.println("Tạo kho hàng thành công!");
        wareHouseList[wareHouseCount - 1].printWareHouse();

    }

    public void add(WareHouse wh){
        wareHouseCount++;
        idCount++;
        wareHouseList[idCount - 1] = wh;
    }

    @Override
    public void edit() {
        while (true){
            if (wareHouseCount <= 0) {
                System.out.println("Danh sách kho hàng trống! Không thể sửa kho hàng!");
                return;
            }
            String[] info = new MenuInput(new String[] {
                "Nhập mã kho hàng cần sửa"
            }).showMenu();
    
            if (info == null) return;
            
            for (int i = 0; i < idCount; i++){
                System.out.println("Test");
                if (wareHouseList[i].getWareHouseId().equals(info[0].trim())){
                    
                    while (true){
                        int select = new MenuSelect(new String[] {
                            "Thay đổi mã kho hàng",
                            "Thay đổi tên kho hàng",
                            "Thay đổi địa chỉ",
                            "Quay lại"
                            }).showMenu();
                            
                            MenuInput[] infoChange = new MenuInput[10];
                            infoChange[0] = new MenuInput(new String[] {
                                "Mã cũ: " + wareHouseList[i].getWareHouseId() + "\nMã mới"
                            });
                            
                            infoChange[1] = new MenuInput(new String[] {
                                "Tên cũ: " + wareHouseList[i].getWareHouseName() + "\nTên mới"
                            });
            
                            infoChange[2] = new MenuInput(new String[] {
                                "Địa chỉ cũ: " + wareHouseList[i].getWareHouseAddString() + "\n Địa chỉ mới"
                            });
                            
                            String strChange;
                            switch (select){
                                case 1:
                                    strChange = infoChange[0].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        if (getWareHouseById(strChange) != null){
                                            System.out.println("Mã mới bị trùng! Không thể đổi mã mới");
                                        }else {
                                            wareHouseList[i].setWareHouseId(strChange);
                                            System.out.println("Đổi mã kho hàng thành công!");
                                            wareHouseList[i].printWareHouse();
                                        }
                                    }
                                    break;
                                case 2:
                                    strChange = infoChange[1].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        wareHouseList[i].setWareHouseName(strChange);
                                        System.out.println("Đổi tên kho hàng thành công!");
                                        wareHouseList[i].printWareHouse();
                                    }else {
                                        System.out.println("Tên kho hàng không được trống!");
                                    }
                                    break;
                                    
                                case 3:
                                    strChange = infoChange[2].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        wareHouseList[i].setWareHouseAddString(strChange);
                                        System.out.println("Đổi địa chỉ kho hàng thành công!");
                                        wareHouseList[i].printWareHouse();
                                    }else {
                                        System.out.println("Địa chỉ kho hàng không được trống!");
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
            System.out.println("Không tìm thấy kho hàng");

        }
        

    }

    @Override
    public void search() {
        if (wareHouseCount == 0){
            System.out.println("Danh sách kho hàng trống, không thể tìm kiếm!");
            return;
        }
        while (true){
            int select = new MenuSelect(new String[] {
                "Tìm kiếm theo mã",
                "Tìm kiếm theo tên",
                "Quay lại"
            }).showMenu();
    
            String[] data;
            WareHouse[] result = null;
            switch (select){
                case 1: 
                    data = new MenuInput(new String[] {
                        "Nhập mã"
                    }).showMenu();
                    WareHouse tmp = getWareHouseById(data[0]);
                    if (tmp != null){
                        result = new WareHouse[1];
                        result[0] = tmp;
                        result[0].printWareHouse();
                    }else 
                        System.out.println("Không tìm thấy kho hàng!");
                    break;
                case 2: 
                    data = new MenuInput(new String[] {
                        "Nhập tên"
                    }).showMenu();
                    result = getWareHouseByName(data[0]);
                    break;                    
                
                case 3:
                    return;
            }  
        }
    }   

    @Override
    public void remove() {
        String[] info = new MenuInput(new String[] {
            "Nhập mã kho hàng cần xoá"
        }).showMenu();

        if (info != null)
            for (int i = 0; i < idCount; i++) {
                if (wareHouseList[i] == null) continue;
                if (wareHouseList[i].getWareHouseId().equals(info[0].trim())) {
                    wareHouseCount--;
                    System.out.println("Đã xoá kho hàng " + wareHouseList[i].getWareHouseName());
                    for (int x = i; x < idCount - 1; x ++){
                        wareHouseList[x] = wareHouseList[x + 1];
                    }
                    wareHouseList[idCount - 1] = null;
                    return;
                }
            }
        
    }


    public void read() {
        String[] data = read(file_url);
        wareHouseCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) continue;
            String[] tmp = data[i].split(",");
            if (getWareHouseById(tmp[0]) != null){
                System.out.println("Thêm kho hàng dòng " + (i + 1) + " không thành công (Mã kho hàng bị trùng)!");
                continue;
            }
            add(new WareHouse(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]));
        }        

    }


    @Override
    public void write() {
        write(file_url, this.wareHouseListToStrings(wareHouseList));
    }

    public WareHouse[] getWareHouseByName(String name){
        WareHouse[] result = new WareHouse[100];
        int index = -1;
        for (int i = 0; i < idCount; i++) {
            if (wareHouseList[i] == null) continue;
            if (wareHouseList[i].getWareHouseName().toLowerCase().contains(name.toLowerCase()) || 
                    wareHouseList[i].getWareHouseName().toLowerCase().contains(Main.removeAccents(name.toLowerCase()))){
                index ++;
                result[index] = wareHouseList[i];
            }
        }  
        if (index > -1){
            System.out.println("Đã tìm thấy " + (index + 1) + " kho hàng");
            // for (Product item : result){
            //     if (item == null) break;
            //     item.printProduct();
            // }
            this.show(result);
        }else {
            System.out.println("Không tìm thấy kho hàng!");
            return null;
        }
        return result;
    }
    public WareHouse getWareHouseById(String id){
        for (int i = 0; i < idCount; i++) {
            if (wareHouseList[i] == null) continue;
            if (wareHouseList[i].getWareHouseId().equals(id.trim())) 
                return wareHouseList[i];
        }
        // System.out.println("Không tìm thấy sản phẩm!");
        return null;
    }
    

    public WareHouse[] getWareHouseList() {
        return wareHouseList;
    }

    public void setWareHouseList(WareHouse[] wareHouseList) {
        this.wareHouseList = wareHouseList;
    }


    public String[] wareHouseListToStrings(WareHouse[] whList) {
        String[] str = new String[100];
        for (int i = 0; i < wareHouseCount; i++){
            str[i] = whList[i].toString();
        }
        return str; 
    }

}