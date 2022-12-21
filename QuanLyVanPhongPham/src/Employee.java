public class Employee extends Human{
    private int hours;
    private float salary;
    public Employee(String firstName, String lastName, int d, int m, int y, String phoneNumber) {
        super(firstName, lastName, d, m, y, phoneNumber);
        this.hours = 0;
        this.salary = 0;
    }
    
}
