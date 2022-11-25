import java.io.IOException;
import java.util.Scanner;

public class MenuInput {
    int num;
    String[] inputString = new String[100];

    public MenuInput(int num, String[] inputString) {
        this.num = num;
        this.inputString = inputString;
    }
    
    public String[] showMenu(){
        
        String[] input = new String[100];
        for (int i = 0; i < num; i++){
            try {
                System.out.print(inputString[i] + ": ");
                input[i] = Main.sc.nextLine();
            }catch (Exception e) {
                System.out.println(e);
                input = null; 
                break;       
            }
        }

        return input;
    }
}
