

import java.sql.Date;

public class Account {
    private int id;
    private String user;
    private String pass;
    private int role; // 0: Customer, 1: Employee, 2:Admin
    private static Account[] accList;
    public static int accCount = 0;

    Account(String user, String pass, int role, String name, Date birthday){ //Create Account from interface
        accCount ++;
        id = accCount;
        this.user = user;
        this.pass = pass;
        this.role = role;

        switch (role){
            case 0: 
                new Admin(id, name, birthday);
            case 1:
                new Employee(id, name, birthday);
            case 2: 
                new Customer(id, name, birthday);
        }
        accList[accCount - 1] = this;
    }

}
