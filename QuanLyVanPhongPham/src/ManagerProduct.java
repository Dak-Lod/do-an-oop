import javax.security.auth.Subject;

public class ManagerProduct extends Manager{
    
    private Product[] productList = new Product[100];

    private int productCount = 0;

    private String file_url = "DSSP.txt";
    
    @Override
    public void add(){
        String[] info = new MenuInput(new String[] {
            "Nhập tên sản phẩm",
            "Nhập giá tiền (Đô la $)",
            "Nhập mô tả sản phẩm"
        }).showMenu();

        
        productCount ++;
        String id = "PRD" + Integer.toString(productCount);
        productList[productCount - 1] = new Product(id, info[0], Float.parseFloat(info[1]), info[2]);
        
        System.out.println("Tạo sản phẩm thành công!");

        productList[productCount - 1].printProduct();

    }

    public void add(Product prd){
        productCount++;
        productList[productCount - 1] = prd;
    }

    public Product getProductById(String id){
        for (int i = 0; i < productCount; i++){
            if (productList[i].getProductId().equals(id.trim()))
                return productList[i];
        }
        System.out.println("Không tìm thấy sản phẩm!");
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
        // TODO Auto-generated method stub
        
    }


    @Override
    public void search() {
        int select = new MenuSelect(new String[] {
            "Tìm kiếm theo mã",
            "Tìm kiếm theo tên",
            "Tìm kiếm theo giá tiền"
        }).showMenu();

        String[] data;

        switch (select){
            case 1: 
                data = new MenuInput(new String[] {
                    "Nhập mã: "
                }).showMenu();
                getProductById(data[0]).printProduct();
                break;
            case 2: 
                 data = new MenuInput(new String[] {
                    "Nhập tên: "
                }).showMenu();
                getProductByName(data[0]);
                break;
            case 3: 
                data = new MenuInput(new String[] {
                    "Nhập mã: "
                }).showMenu();
                getProductByPrice(data[0]);
                break;
        }
    }   

    Product[] getProductByPrice(String price){
        return getProductByPrice(Float.parseFloat(price));
    }

    Product[] getProductByPrice(Float price){
        Product[] result = new Product[100];
        int index = -1;
        for (Product item : productList) {
            if (item.getPrice() == price){
                index ++;
                result[index] = item;
            }
        }  
        System.out.println("Đã tìm thấy " + index + " sản phẩm");
        return result;
    }

    Product[] getProductByName(String name){
        Product[] result = new Product[100];
        int index = -1;
        for (Product item : productList) {
            if (item.getProductName().indexOf(name) > -1){
                index ++;
                result[index] = item;
            }
        }  
        System.out.println("Đã tìm thấy " + index + " sản phẩm");
        return result;
    }

    Product geProductById(String id){
        for (Product prd : productList) {
            if (prd == null) return null;
            if (prd.getProductId() == id.trim()) 
                return prd;
        }
        System.out.println("Không tìm thấy sản phẩm!");
        return null;
    }


    @Override
    public void show() {
        if (productCount == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.printf("\t\t\t    %-20s    \t\t\t\n", "DANH SÁCH SẢN PHẨM");
        for (int i = 0; i < 77; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf("|%-7s|%-7s|%-14s|%-14s|%-29s|\n", "STT", "ID", "Tên sản phẩm", "Đơn giá", "Mô tả");
        for (int i = 0; i < 77; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < productCount; i++){
            System.out.printf("|%-7s|%-7s|%-14s|%-14s|%-29s|\n", i,productList[i].getProductId(),productList[i].getProductName(), productList[i].getPrice(), productList[i].getDes());
        }
        for (int i = 0; i < 77; i++)
            System.out.print("=");
        System.out.println();
    }


    public void read() {
        String[] data = read(file_url);
        productCount = 0;
        for (String line : data) {
            if (line == null) continue;
            String[] tmp = line.split(",");
            add(new Product(tmp[0], tmp[1], Float.parseFloat(tmp[2]), tmp[3]));
        }        

    }


    public void write() {
        write(file_url, this.productListToStrings(productList));
    }


    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
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
