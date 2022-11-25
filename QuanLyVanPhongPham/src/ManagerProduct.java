import javax.security.auth.Subject;

public class ManagerProduct extends Manager{
    
    private Product[] productList = new Product[100];

    private int productCount = 0;
    
    @Override
    public void add(){
        String[] info = new MenuInput(3, new String[] {
            "Nhập tên sản phẩm",
            "Nhập giá tiền (Đô la $)",
            "Nhập mô tả sản phẩm"
        }).showMenu();

        
        String id = "PRD" + Integer.toString(productCount);
        productList[productCount] = new Product(id, info[0], Float.parseFloat(info[1]), info[2]);
        productCount ++;
        
        System.out.println("Tạo sản phẩm thành công!");

        productList[productCount - 1].show();

    }

    public void add(Product prd){
        productCount++;
        productList[productCount - 1] = prd;
    }

    public Product getProductById(String id){
        for (int i = 0; i < productCount; i++){
            if (productList[i].productId == id.trim())
                return productList[i];
        }
        return null;
    }



    public void main(String[] args) {
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
            if (select == 7) return;
            getMethod(select);

        }
    }


    @Override
    public void edit() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void search() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void read() {
        String url = "DSSP.txt";
        String[] data = read(url);
        for (String line : data) {
            String[] tmp = line.split(",");
            if (line == null) continue;
            add(new Product(tmp[0], tmp[1], Float.parseFloat(tmp[3]), tmp[2]));
        }        
    }


    @Override
    public void write() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }

}
