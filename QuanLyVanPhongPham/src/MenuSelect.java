import java.util.Scanner;

public class MenuSelect {
    private int num;
    private String[] method;
    static Scanner sc = new Scanner(System.in);

    

    public MenuSelect(int num, String[] method) {
        this.num = num;
        this.method = method;
    }



    public int showMethod(){
        int selection;
        try {
            for (int i = 0; i < num; i++){
                System.out.println(i + 1 + ". "+ method[i]);
            }
            System.out.print("Nhập số tương ứng với chức năng bạn chọn: ");
            selection = sc.nextInt();
            if (selection < 1 && selection > num)
                System.out.println("Lựa chọn sai!");
            
        }finally {
            System.out.println("Lỗi!");
            selection = -1;
        }
        return selection;
    }
}
