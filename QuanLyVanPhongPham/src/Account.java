

import java.sql.Date;

public class Account {
    private int id;
    private String user;
    private String pass;
    private int role; // 0: Customer, 1: Employee, 2:Admin
    public static int accCount = 0;

    Account(String user, String pass, int role, String name, Date birthday){ //Create Account from interface
        accCount ++;
        id = accCount;
        this.user = user;
        this.pass = pass;
        this.role = role;
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
}
