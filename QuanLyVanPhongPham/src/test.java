public class test {
    public static void main(String[] args) {
        
        
        String[] tmp = new String[100];

        tmp[0] = "1";
        tmp[1] = "2";
        for (String string : tmp) {
            if (string == null) break;
            System.out.println(string);
        }
        
    }
}
