import java.io.IOException;
import java.util.Scanner;

public class MenuInput {
    String[] inputString;

    public MenuInput( String[] inputString) {
        this.inputString = inputString;
    }
    
    public String[] showMenu(){
        
        String[] input = new String[100];
        for (int i = 0; i < inputString.length; i++){
            try {
                System.out.print(inputString[i] + ": ");
                input[i] = Main.sc.nextLine();
            }catch (Exception e) {
                System.out.println("Nhập lỗi!");
                input = null; 
                break;       
            }
        }
        return input;
    }
}
