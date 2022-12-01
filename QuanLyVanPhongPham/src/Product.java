public class Product {
    private String productId;
    private String productName;
    private float price;
    private String des;
    private int qty;
    
    public String getProductId() {
        return productId;
    }


    public void setProductId(String productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getDes() {
        return this.des;
    }


    public void setDescription(String des) {
        this.des = des;
    }


    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        this.price = price;
    }


    public Product(String productId, String productName, float price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.des = description;
        this.price = price;
        this.qty = 0;
    }

    public void printProduct() {
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println();
        
        System.out.printf("|\t%-36s\t|\n", "Mã sản phẩm: " + this.productId);
        System.out.printf("|\t%-36s\t|\n", "Tên sản phẩm: " + this.productName);
        System.out.printf("|\t%-36s\t|\n","Giá thành: " + this.price + "$");
        System.out.printf("|\t%-36s\t|\n","Mô tả: " + this.des);
        System.out.printf("|\t%-36s\t|\n","Kho: " + this.qty);
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println("\n");
    }    

    @Override
    public String toString() {
        return String.join(",", productId, productName, Float.toString(price), des);
    }
}

