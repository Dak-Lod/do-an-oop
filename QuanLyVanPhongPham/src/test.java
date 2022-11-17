public class test {
    public static void main(String[] args) {
        
        //Tạo giao diện nhập thông tin người dùng
        String[] input =  new MenuInput(4, new String[] {"Nhập họ", "Nhập tên", "Nhập ngày tháng năm sinh (dd/mm/yyyy)", "Nhập số điện thoại"}).showMenu();

        // Chuyển đổi ngày tháng năm
        int d, m, y;
        String[] tmp = input[2].split("/");
        // System.out.println(tmp[0] + tmp[1] + tmp[2]);
        d = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        y = Integer.parseInt(tmp[2]);

        new Human(input[0], input[1], d, m, y, input[3]).export();

    }
}
