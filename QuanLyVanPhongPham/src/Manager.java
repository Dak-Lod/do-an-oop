import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


abstract class Manager implements ManagerMethod{

    int getMethod(int select){
        switch (select){
            case 1:
                show();
                break;
            case 2:
                add();
                break;
            case 3:
                search();
                break;
            case 4:
                edit();
                break;
            case 5:
                remove();
                break;
            case 6:
                read();
                break;
            case 7:
                write();
                break;
            case 8:
                return -1;
            case 9:
                Main.exit();
                break;
        }
        return 0;
    }

    String[] read(String url){
        String[] data = new String[100];
        try {
            FileReader fi = new FileReader(url);
            BufferedReader fiBuf = new BufferedReader(fi);

            String input = fiBuf.readLine();
            int index = -1;

            while (input != null){
                index++;
                data[index] = input;
                input = fiBuf.readLine();
            }
            
            fiBuf.close();
            System.out.println("Đọc file thành công!");
            return data;
        }catch (Exception e){
            System.out.println("Đọc file không thành công!");
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
            System.out.println("Ghi file thành công!");
        }catch (Exception e){
            System.out.println("Ghi file không thành công!");
            System.out.println(e);
        }
    }

    

}
