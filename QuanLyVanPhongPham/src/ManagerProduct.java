import javax.security.auth.Subject;

public class ManagerProduct extends Manager{
    
    private Product[] productList = new Product[100];

    private int productCount = 0;
    private int idCount = 0;

    private String file_url = "DSSP.txt";
    
    @Override
    public void add(){
        String[] info = new MenuInput(new String[] {
            "Nhập tên sản phẩm",
            "Nhập giá tiền (Đô la $)",
            "Nhập mô tả sản phẩm"
        }).showMenu();

        if (info == null) return;
        productCount ++;
        idCount ++;
        String id = "PRD" + Integer.toString(idCount);
        productList[productCount - 1] = new Product(id, info[0], Float.parseFloat(info[1]), info[2]);
        
        System.out.println("Tạo sản phẩm thành công!");

        productList[productCount - 1].printProduct();

    }

    public void add(Product prd){
        productCount++;
        idCount++;
        productList[idCount - 1] = prd;
    }

    public Product[] getProductByPrice(String min, String max){
        if (min.trim() == "")
            min = "0";
        if (max.trim() == "")
            max = "99999999999999999999999";
        return getProductByPrice(Float.parseFloat(min), Float.parseFloat(max));
    }
    
    public Product[] getProductByPrice(float min, float max){
        Product[] result = new Product[100];
        int index = -1;
        for (int i = 0; i < idCount; i++) {
            if (productList[i] == null) continue;
            if (productList[i].getPrice() >= min && productList[i].getPrice() <= max){
                index++;
                result[index] = productList[i];
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

    public Product[] getProductByName(String name){
        Product[] result = new Product[100];
        int index = -1;
        for (int i = 0; i < idCount; i++) {
            if (productList[i] == null) continue;
            if (productList[i].getProductName().toLowerCase().indexOf(name.toLowerCase()) > -1 || 
            productList[i].getProductName().toLowerCase().indexOf(Main.removeAccents(name.toLowerCase())) > -1){
                index ++;
                result[index] = productList[i];
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

    public Product getProductById(String id){
        for (int i = 0; i < idCount; i++) {
            if (productList[i] == null) continue;
            if (productList[i].getProductId().equals(id.trim())) 
                return productList[i];
        }
        // System.out.println("Không tìm thấy sản phẩm!");
        return null;
    }
    


    public void main(String[] args) {
        while (true) {
            MenuSelect menu = new MenuSelect(new String[] {
                "Danh sách sản phẩm",
                "Thêm sản phẩm",
                "Tìm kiếm sản phẩm",
                "Sửa sản phẩm",
                "Xoá sản phẩm",
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
    public void edit() {
        while (true){
            if (productCount <= 0) {
                System.out.println("Danh sách sản phẩm trống! Không thể sửa sản phẩm!");
                return;
            }
            String[] info = new MenuInput(new String[] {
                "Nhập mã sản phẩm cần sửa"
            }).showMenu();
    
            if (info == null) return;
            
            for (int i = 0; i < idCount; i++){
                System.out.println("Test");
                if (productList[i].getProductId().equals(info[0].trim())){
                    
                    while (true){
                        int select = new MenuSelect(new String[] {
                            "Thay đổi mã sản phẩm",
                            "Thay đổi tên sản phẩm",
                                "Thay đổi giá sản phẩm",
                                "Thay đổi mô tả sản phẩm",
                                "Quay lại"
                            }).showMenu();
                            
                            MenuInput[] infoChange = new MenuInput[10];
                            infoChange[0] = new MenuInput(new String[] {
                                "Mã cũ: " + productList[i].getProductId() + "\nMã mới"
                            });
            
                            infoChange[1] = new MenuInput(new String[] {
                                "Tên cũ: " + productList[i].getProductName() + "\nTên mới"
                            });
            
                            infoChange[2] = new MenuInput(new String[] {
                                "Giá cũ: " + productList[i].getProductId() + "\nGiá mới"
                            });
            
                            infoChange[3] = new MenuInput(new String[] {
                                "Mô tả cũ: " + productList[i].getProductId() + "\nMô tả mới"
                            });
            
                            String strChange;
                            switch (select){
                                case 1:
                                    strChange = infoChange[0].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        if (getProductById(strChange) != null){
                                            System.out.println("Mã mới bị trùng! Không thể đổi mã mới");
                                        }else {
                                            productList[i].setProductId(strChange);
                                            System.out.println("Đổi mã sản phẩm thành công!");
                                            productList[i].printProduct();
                                        }
                                    }
                                    break;
                                case 2:
                                    strChange = infoChange[1].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        productList[i].setProductName(strChange);
                                        System.out.println("Đổi tên sản phẩm thành công!");
                                        productList[i].printProduct();
                                    }else {
                                        System.out.println("Tên sản phẩm không được trống!");
                                    }
                                    break;
                                    
                                case 3:
                                    strChange = infoChange[2].showMenu()[0];
                                    if (!strChange.trim().equals("")){
                                        productList[i].setPrice(Float.parseFloat(strChange));
                                        System.out.println("Đổi giá sản phẩm thành công!");
                                        productList[i].printProduct();
                                    }else {
                                        System.out.println("Giá sản phẩm không được trống!");
                                    }
                                    break;
                                    
                                case 4:
                                    strChange = infoChange[2].showMenu()[0];
                                    if (strChange != null){
                                        productList[i].setDescription(strChange);
                                        System.out.println("Đổi mô tả sản phẩm thành công!");
                                        productList[i].printProduct();
                                    }
                                    break;
        
                                case 5:
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


    @Override
    public void search() {
        if (productCount == 0){
            System.out.println("Danh sách sản phẩm trống, không thể tìm kiếm!");
            return;
        }
        while (true){
            int select = new MenuSelect(new String[] {
                "Tìm kiếm theo mã",
                "Tìm kiếm theo tên",
                "Tìm kiếm theo giá tiền",
                "Quay lại"
            }).showMenu();
    
            String[] data;
            Product[] result = null;
            switch (select){
                case 1: 
                    data = new MenuInput(new String[] {
                        "Nhập mã"
                    }).showMenu();
                    Product tmp = getProductById(data[0]);
                    if (tmp != null){
                        result = new Product[1];
                        result[0] = tmp;
                        result[0].printProduct();
                    }else 
                        System.out.println("Không tìm thấy sản phẩm!");
                    break;
                case 2: 
                    data = new MenuInput(new String[] {
                        "Nhập tên"
                    }).showMenu();
                    result = getProductByName(data[0]);
                    break;                    
                    
                case 3: 
                    data = new MenuInput(new String[] {
                        "Nhập giá thấp nhất",
                        "Nhập giá lớn nhất"
                    }).showMenu();
                    result = getProductByPrice(data[0], data[1]);
                    continue;
                case 4:
                    return;
            }  
        }
    }   

    


    @Override
    public void show() {
        show(productList);
    }

    public void show(Product[] prd) {
        if (prd[0] == null) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.printf("\t\t\t           %-21s           \t\t\t\n", "DANH SÁCH SẢN PHẨM");
        for (int i = 0; i < 92; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf("|%-7s|%-7s|%-29s|%-14s|%-29s|\n", "STT", "ID", "Tên sản phẩm", "Đơn giá", "Mô tả");
        for (int i = 0; i < 92; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < prd.length; i++){
            if (prd[i] == null) break;
            System.out.printf("|%-7s|%-7s|%-29s|%-14s|%-29s|\n", (i + 1),prd[i].getProductId(),prd[i].getProductName(), prd[i].getPrice(), prd[i].getDes());
        }
        for (int i = 0; i < 92; i++)
            System.out.print("=");
        System.out.println();
    }

    public void read() {
        String[] data = read(file_url);
        productCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) continue;
            String[] tmp = data[i].split(",");
            if (getProductById(tmp[0]) != null){
                System.out.println("Thêm sản phẩm dòng " + (i + 1) + " không thành công (Mã sản phẩm bị trùng)!");
                continue;
            }
            add(new Product(tmp[0], tmp[1], Float.parseFloat(tmp[2]), tmp[3]));
        }        

    }


    public void write() {
        write(file_url, this.productListToStrings(productList));
    }


    @Override
    public void remove() {
        String[] info = new MenuInput(new String[] {
            "Nhập mã sản phẩm cần xoá"
        }).showMenu();

        if (info != null)
            for (int i = 0; i < idCount; i++) {
                if (productList[i] == null) continue;
                if (productList[i].getProductId().equals(info[0].trim())) {
                    productCount--;
                    System.out.println("Đã xoá sản phẩm " + productList[i].getProductName());
                    for (int x = i; x < idCount - 1; x ++){
                        productList[x] = productList[x + 1];
                    }
                    productList[idCount - 1] = null;
                    return;
                }
            }
        
    }

    public Product[] getProductList() {
        return productList;
    }

    public void setProductList(Product[] productList) {
        this.productList = productList;
    }


    public String[] productListToStrings(Product[] prdList) {
        String[] str = new String[100];
        for (int i = 0; i < productCount; i++){
            str[i] = prdList[i].toString();
        }
        return str; 
    }

}
