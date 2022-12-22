public class Account {
    private String id;
    private String user;
    private String pass;
    private int role; // 0: Customer, 1: Employee, 2:Admin
    private Human info;
    
    Account(String id, String user, String pass, int role, String firstName, String lastName, Date date, String phoneNum){ //Create Account from interface
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.role = role;
        switch (role) {
            case 0: 
                this.info = new Admin(firstName, lastName, date.day, date.month, date.year, phoneNum);
                break;
            case 1:
                this.info = new Employee(firstName, lastName, date.day, date.month, date.year, phoneNum);
                break;
            case 2:
                this.info = new Customer(firstName, lastName, date.day, date.month, date.year, phoneNum);
                break;
        }
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Human getInfo() {
        return info;
    }

    public void setInfo(Human info) {
        this.info = info;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void printAccount() {
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println();
        
        System.out.printf("|\t%-36s\t|\n", "Mã tài khoản: " + this.id);
        System.out.printf("|\t%-36s\t|\n", "username tài khoản: " + this.user);
        String role = "";
        switch (this.role){
            case 0:
                role = "Quản trị";
                break;
            case 1:
                role = "Nhân viên";
                break;
            case 2:
                role = "Khách hàng";
                break;
        }
        System.out.printf("|\t%-36s\t|\n","Quyền tài khoản: " + role);
        for (int i = 0; i < 49;i++){
            System.out.print("=");
        }
        System.out.println("\n");
    }
    
    @Override
    public String toString() {
        return String.join(",", new String[] {
            id, user, pass, Integer.toString(role), info.getName().firstName, info.getName().lastName, info.getBirthDayString(), info.getPhoneNumber()
        });
    }
}
