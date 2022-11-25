public class Product {
    String productId;
    String productName;
    float price;
    String des;
    
    
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
    }

    public void show() {
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println();
        
        System.out.printf("|\t%-36s\t|\n", "Mã sản phẩm: " + this.productId);
        System.out.printf("|\t%-36s\t|\n", "Tên sản phẩm: " + this.productName);
        System.out.printf("|\t%-36s\t|\n","Giá thành: " + this.price + "$");
        System.out.printf("|\t%-36s\t|\n","Mô tả: " + this.des);
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println("\n");
    }    

}

