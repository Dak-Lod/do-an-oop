import java.util.InputMismatchException;
public class MenuSelect {
    private String[] method;

    

    public MenuSelect(String[] method) {
        this.method = method;
    }



    public int showMenu(){
        while (true){
            String selection;
            for (int i = 0; i < 52; i++)
                System.out.print("-");
            System.out.println("");
    
            try {
                int index = 0;
                for (String str: method){
                    System.out.printf("|\t%-43s|\n", ++index + ". "+ str);
                }
                for (int i = 0; i < 52; i++)
                    System.out.print("-");
                System.out.println("");
                System.out.print("Nhập số tương ứng với chức năng bạn chọn: ");
                selection = Main.sc.nextLine();
                try {
                    Integer.parseInt(selection);
                }catch (Exception e){
                    throw new InputMismatchException();
                }
                if (Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > method.length){
                    throw new InputMismatchException();
                }
                System.out.println("\nĐã chọn chức năng: " + this.method[Integer.parseInt(selection) - 1]);
                
            }catch (Exception e) {
                System.out.println("Lựa chọn sai!");
                // selection = "-1";
                continue;
            }
            return Integer.parseInt(selection);
        }
    }
}
