import java.util.Scanner;

public class MenuSelect {
    private int num;
    private String[] method;

    

    public MenuSelect(int num, String[] method) {
        this.num = num;
        this.method = method;
    }



    public String showMenu(){
        String selection;
        for (int i = 0; i < 52; i++)
            System.out.print("-");
        System.out.println("");

        try {
            for (int i = 0; i < num; i++){
                System.out.printf("|\t%-43s|\n", i + 1 + ". "+ method[i]);
            }
            for (int i = 0; i < 52; i++)
                System.out.print("-");
            System.out.println("");
            System.out.print("Nhập số tương ứng với chức năng bạn chọn: ");
            selection = Main.sc.nextLine();
            if (Integer.parseInt(selection)< 1 && Integer.parseInt(selection) > num)
                System.out.println("Lựa chọn sai!");
            
        }catch (Exception e) {
            System.out.println(e);
            selection = null;
        }
        return selection;
        
    }
}
