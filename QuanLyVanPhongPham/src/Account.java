public class Account {
    private String id;
    private String user;
    private String pass;
    private String name;
    private Human info;
    private int role; // 0: Customer, 1: Employee, 2:Admin
    public static int accCount = 0;
    
    Account(String user, String pass, int role, String name, Date birthday){ //Create Account from interface
        accCount ++;
        id = Integer.toString(accCount);
        this.user = user;
        this.pass = pass;
        this.role = role;
        this.name = name;

        if (role == 0) {
            
        }
    }
    
    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(String user) {
    this.user = user;
    }

    public String getUser(){
        return this.user;
    }

    public String getPass(){
        return this.pass;
    }

    public int getRole(){
        return this.role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printAccount() {
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println();
        
        System.out.printf("|\t%-36s\t|\n", "Mã tài khoản: " + this.id);
        System.out.printf("|\t%-36s\t|\n", "username tài khoản: " + this.user);
        System.out.printf("|\t%-36s\t|\n","Quyền tài khoản: " + this.role);
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println("\n");
    }
    
    @Override
    public String toString() {
        return String.valueOf(",");
    }
}
