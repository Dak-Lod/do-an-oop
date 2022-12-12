
public class Address {
    private String addressNum;
    private String street;
    private String state;
    private String city;
    

    public Address(String addressNum, String street, String state, String city) {
        this.addressNum = addressNum;
        this.street = street;
        this.state = state;
        this.city = city;
    }

    public String getAddressNum() {
        return addressNum;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void printAddress() {
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println();
        
        System.out.printf("|\t%-36s\t|\n", "Địa chỉ số: " + this.addressNum);
        System.out.printf("|\t%-36s\t|\n", "Đường: " + this.street);
        System.out.printf("|\t%-36s\t|\n","Quận: " + this.state);
        System.out.printf("|\t%-36s\t|\n","Thành phố: " + this.city);
        
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println("\n");
    }    

    @Override
    public String toString() {
        return addressNum + "," + street + "," + state + "," + city;
    }

    
}
