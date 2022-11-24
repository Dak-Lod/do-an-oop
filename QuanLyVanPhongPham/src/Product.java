public class Product {
    int productId;
    String productName;
    String des;
    float price;
    
    
    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
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


    public Product(int productId, String productName, String description, float price) {
        this.productId = productId;
        this.productName = productName;
        this.des = description;
        this.price = price;
    }

    

}

