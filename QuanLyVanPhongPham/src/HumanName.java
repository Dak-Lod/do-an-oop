public class HumanName {
    public String firstName;
    public String lastName;
    public HumanName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return  firstName + " " + lastName;
    }
    
    
}
