public class Main {

    // Human[] humans;
    public static Account[] accList;
    

    public static void main(String[] args) {
        MenuSelect mainMenu = new MenuSelect(2, new String[] {"Login", "Xem tình trạng hoá đơn"});
        switch (mainMenu.showMethod()){
            case 1:
                LoginMenu.main(null);
                break;
            case 2:
                
                break;
        };


    }

}