
public class WareHouse {
    private String wareHouseId;
    private Address wareHouseAdd;
    private String wareHouseName;
    private Address[] address;
    private WareHouse[] wareHouse;

    public WareHouse(String wareHouseId, String wareHouseName, String addressNum, String street, String state, String city) {
        this.wareHouseId = wareHouseId;
        this.wareHouseName = wareHouseName;
        this.wareHouseAdd = new Address(addressNum, street, state, city);
        
    }
    
    public String getWareHouseId() {
        return wareHouseId;
    }

    public Address getWareHouseAdd() {
        return wareHouseAdd;
    }
    public String getWareHouseAddString() {
        return wareHouseAdd.toString();
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public Address[] getAddress() {
        return address;
    }

    public WareHouse[] getWareHouse() {
        return wareHouse;
    }

    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public void setWareHouseAdd(Address wareHouseAdd) {
        this.wareHouseAdd = wareHouseAdd;
    }   
    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public void setAddress(Address[] address) {
        this.address = address;
    }

    public void setWareHouse(WareHouse[] wareHouse) {
        this.wareHouse = wareHouse;
    }
   
    public void setWareHouseAddString(String strChange) {
       
    }
    
    public void printWareHouse() {
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println();
        
        System.out.printf("|\t%-36s\t|\n", "Mã kho hàng: " + this.wareHouseId);
        System.out.printf("|\t%-36s\t|\n", "Tên kho hàng: " + this.wareHouseName);
        System.out.printf("|\t%-36s\t|\n", "Địa chỉ kho hàng: " + this.wareHouseAdd);
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println("\n");
    }    

    @Override
    public String toString() {
        return String.join(",", wareHouseId, wareHouseName, wareHouseAdd.toString());
    }

}
