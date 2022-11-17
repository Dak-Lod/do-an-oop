public class Human {
    private int id;
    private HumanName name;
    private Date birthday;
    private int old;
    private String phoneNumber;
    
    public static int count = 0;
    
    public Human(String firstName, String lastName, int d, int m, int y, String phoneNumber) {
        count++;
        this.id = count;
        this.name = new HumanName(firstName, lastName);
        this.birthday = new Date(d, m, y);
        this.old = Date.now().toInt() -  this.birthday.toInt();
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }


    public HumanName getName() {
        return name;
    }


    public void setName(HumanName name) {
        this.name = name;
    }


    public Date getBirthday() {
        return birthday;
    }

    public String getBirthDayString(){
        return birthday.toString();
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public int getOld() {
        return old;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public int setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10){
            System.out.println("Số điện thoại phải có 10 số!");
            return -1;
        }
        this.phoneNumber = phoneNumber;
        return 0;
    }
    
    public void export(){
        System.out.println(id + " " + name.toString() + " " + birthday.toString()+ " " + old + " " + phoneNumber);
    }

}