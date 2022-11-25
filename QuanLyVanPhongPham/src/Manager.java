import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


abstract class Manager implements ManagerMethod{

    void getMethod(int select){
        switch (select){
            case 1:
                add();
                break;
            case 2:
                search();
                break;
            case 3:
                edit();
                break;
            case 4:
                remove();
                break;
            case 5:
                read();
                break;
            case 6:
                write();
                break;
            case 8:
                Main.exit();
                break;

        }
    }

    String[] read(String url){
        String[] data = new String[100];
        try {
            FileReader fi = new FileReader(url);
            BufferedReader fiBuf = new BufferedReader(fi);

            String input = fiBuf.readLine();
            int index = -1;

            while (input != null){
                input = fiBuf.readLine();
                index++;
                data[index] = input;
            }
            
            fiBuf.close();
            return data;
        }catch (Exception e){
            System.out.println("Đọc không thành công!");
            System.out.println(e);
            return null;
        }

    }

    void write(String url, String[] data){
        try {
            FileWriter fo = new FileWriter(url);
            BufferedWriter foBuf = new BufferedWriter(fo);

            for (String line : data) {
                if (line == null) break;
                foBuf.write(line + "\n");
            }

            foBuf.close();
        }catch (Exception e){
            System.out.println("Ghi không thành công!");
            System.out.println(e);
        }
    }

    

}
