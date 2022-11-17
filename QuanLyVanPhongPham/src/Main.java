public class Main {

    // Human[] humans;
    public static Account[] accList;
    
    static private String[] stringMenu = {"Login", "Xem tình trạng hoá đơn"}; 

    public static void main(String[] args) {
        MenuSelect mainMenu = new MenuSelect(2, stringMenu);
        switch (mainMenu.showMethod()){
            case 1:
                LoginMenu.main(null);
                break;
            case 2:
                
                break;
        };


    }

}