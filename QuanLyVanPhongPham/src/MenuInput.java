public class MenuInput {
    String[] inputString;

    public MenuInput( String[] inputString) {
        this.inputString = inputString;
    }
    
    public String[] showMenu(){
        
        String[] input = new String[100];
        for (int i = 0; i < inputString.length; i++){
            try {
                System.out.print(inputString[i] + " (/ex để thoát nhập)" + ": ");
                input[i] = Main.sc.nextLine();
                if (input[i].indexOf("/ex") > -1){
                    return null;
                }
            }catch (Exception e) {
                System.out.println("Nhập lỗi!");
                input = null; 
                break;       
            }
        }
        return input;
    }
}
