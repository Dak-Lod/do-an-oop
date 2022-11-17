import java.util.Scanner;

public class LoginMenu{
    private String[] stringMenu = {""};
    public static void main(String[] args) {
        String[] menuStr = {"Nhập tài khoản: ", "Nhập mật khẩu: "};
        String[] inputData = new MenuInput(2, menuStr).showMenu();
        for (int i = 0; i < Account.accCount; i++){
            if (inputData[0] == Main.accList[i].getUser() && inputData[1] == Main.accList[i].getPass())
                switch (Main.accList[i].getRole()){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;

                }   
        }

    }

}
