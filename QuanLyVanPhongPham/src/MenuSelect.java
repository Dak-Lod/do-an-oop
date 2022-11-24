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
        try {
            for (int i = 0; i < num; i++){
                System.out.println(i + 1 + ". "+ method[i]);
            }
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
