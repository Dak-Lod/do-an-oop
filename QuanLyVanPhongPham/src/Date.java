import java.time.LocalDate;

public class Date{
    protected int day;
    protected int month;
    protected int year;
    private boolean leap; //Năm nhuận
    

    public Date(int day, int month, int year) {
        // this.day = day;
        // this.month = month;
        // this.year = year;
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    public static int dayOfMonth(int month, int year){
        switch (month - 1){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return  31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (Date.isLeapYear(year)){
                    return 29;
                }else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    public static Date now(){
        int d, m, y;
        LocalDate now = java.time.LocalDate.now();
        d = now.getDayOfMonth();
        m = now.getMonthValue();
        y = now.getYear();
        return new Date(d, m, y);
    }
    
    public int toInt(){

        int total = this.day;

        for (int i = 1; i < this.month; i++)
            total += Date.dayOfMonth(i, this.year);

        total += (this.year - 1) * 365 + (this.year - 1) / 4 - (this.year - 1) /100 + (this.year - 1) / 400;

        return total;
    }

    public static int toInt(int d, int m, int y){

        int total = d;

        for (int i = 1; i < m; i++)
            total += Date.dayOfMonth(i, y);

        total += (y - 1) * 365 + (y - 1) / 4 - (y - 1) /100 + (y - 1) / 400;

        return total;
    }



    public int getDay() {
        return day;
    }

    public int setDay(int day) {
        if (day < 1 || day > 31){
            System.out.println("Số ngày không hợp lệ!");
            return -1;
        }
        this.day = day;
        return 0;
    }

    public int getMonth() {
        return month;
    }

    public int setMonth(int month) {
        if (month < 1 || month > 12){
            System.out.println("Số tháng không hợp lệ!");
            return - 1;
        }
        this.month = month;
        return 0;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLeap() {
        return leap;
    }

    public void setLeap(boolean leap) {
        this.leap = leap;
    }

    
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}