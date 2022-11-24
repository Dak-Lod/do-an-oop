public class ManagerProduct implements ManageInter {
    
    static Product[] productList = new Product[100];

    static int productCount = 0;


    public static void add(){
        String[] info = new MenuInput(3, new String[] {
            "Nhập tên sản phẩm",
            "Nhập mô tả sản phẩm",
            "Nhập giá tiền (Đô la $)"
        }).showMenu();

        productCount ++;
        productList[productCount - 1] = new Product(productCount, info[0], info[1],Float.parseFloat(info[2]));

    }

    public static Product getProductById(int id){
        for (int i = 0; i < productCount; i++){
            if (productList[i].productId == id)
                return productList[i];
        }
        return null;
    }

    public static Product getProductById(String id){
        return getProductById(Integer.parseInt(id));
    }



    public static void main(String[] args) {
        MenuSelect menu = new MenuSelect( 8,new String[] {
            "Thêm sản phẩm",
            "Tìm kiếm sản phẩm",
            "Sửa sản phẩm",
            "Xoá sản phẩm",
            "Đọc",
            "Ghi",
            "Quay lại",
            "Thoát"
        });
        while (true) {
            int select =  menu.showMenu();
    
            switch (select) {
                case 1:
                    add();
                    break;
                case 7:
                    return;
                case 8:
                    Main.exit();
            }

        }
    }

}
