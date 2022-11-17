import java.util.Scanner;

public class MenuInput {
    int num;
    String[] inputString = new String[100];

    public MenuInput(int num, String[] inputString) {
        this.num = num;
        this.inputString = inputString;
    }
    
    public String[] showMenu(){
        Scanner sc = new Scanner(System.in);
        String[] input = new String[100];
        for (int i = 0; i < num; i++){
            System.out.print(inputString[i] + ":");
            input[i] = new String(sc.nextLine());
        }
        return input;
    }
}
