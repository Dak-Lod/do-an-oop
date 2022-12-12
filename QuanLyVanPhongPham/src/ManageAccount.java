public class ManageAccount extends Manager{
    private static Account[] accList = new Account[100];
    
    private static int accCount = 0;
    private static int idCount = 0;

    private String file_url = "accList.txt";

    public void main(String[] args) {
        while (true) {
            MenuSelect menu =  new MenuSelect(new String[] {
                "Danh sách tài khoản",
                "Thêm tài khoản",
                "Tìm kiếm tài khoản",
                "Sửa tài khoản",
                "Xoá tài khoản",
                "Đọc",
                "Ghi",
                "Quay lại",
                "Thoát"
            });
            int select = menu.showMenu();
            if (getMethod(select) == -1) return;
        }
    }

    @Override
    public void show (){
        show(accList);
    }

    public void show (Account[] acc){
        if (acc[0] == null) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.printf("\t\t\t    %-20s    \t\t\t\n", "DANH SÁCH TÀI KHOẢN");
        for (int i = 0; i < 92; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf("|%-14s|%-14s|\n", "USERNAME", "ROLE");
        for (int i = 0; i < 92; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < acc.length; i++){
            if (acc[i] == null) break;
            System.out.printf("|%-7s|%-14s|%-14s|\n", i, accList[i].getUser(), accList[i].getRole());
        }
        for (int i = 0; i < 92; i++)
            System.out.print("=");
        System.out.println();
    }

    @Override
    public void add(){
        String[] info = new MenuInput(new String[] {
            "Nhập username",
            "Nhập mật khẩu",
            "Nhập quyền (0/1/2)",
            "Nhập tên tài khoản",
            "Nhập năm sinh (dd/mm/yyyy)",    
        }).showMenu();   

        if (info == null) return;
        accCount ++;
        idCount ++;
        accList[accCount - 1] = new Account(info[0], info[1], Integer.parseInt(info[2]), info[3], Date.createDateFromString(info[4]));

        System.out.println("Tạo tài khoản thành công!");

        accList[accCount - 1].printAccount();
    }

    public void add(Account acc){
        accCount ++;
        idCount ++;
        accList[accCount - 1] = acc;
    }
    
    @Override
    public void edit() {
        while (true){
            if (accCount <= 0){
                System.out.println("Danh sách tài khoản trống, không thể sửa tài khoản");
                return;
            }
            String[] info = new MenuInput(new String[] {
                "Nhập mã tài khoản cần sửa",
            }).showMenu();

            if (info == null) return;

            for (int i = 0; i < idCount; i++){
                System.out.println("Test");
                if (accList[i].getId().equals(info[0].trim())){
                    while (true){
                        int select = new MenuSelect(new String[]{
                            "Thay đổi mã tài khoản",
                            "Thay đổi username",
                            "Thay đổi pass",
                            "Thay đổi quyền",
                            "Quay lại",
                        }).showMenu();

                        MenuInput[] infoChange = new MenuInput[10];
                        infoChange[0] = new MenuInput(new String[] {
                            "id cũ: " + accList[i].getId() + "\nid mới"
                        });
                        infoChange[1] = new MenuInput(new String[] {
                            "username cũ: " + accList[i].getId() + "\nusername mới"
                        });
                        
                        infoChange[2] = new MenuInput(new String[] {
                            "pass cũ: " + accList[i].getId() + "\npass mới"
                        });
        
                        infoChange[3] = new MenuInput(new String[] {
                            "quyền cũ: " + accList[i].getId() + "\nquyền mới"
                        });

                        String strChange;
                        switch (select){
                            case 1:
                                strChange = infoChange[1].showMenu()[0];
                                if (!strChange.trim().equals("")){
                                    if (getAccountbyId(strChange) != null){
                                        System.out.println("id mới bị trùng, không thể đổi!");
                                    } else {
                                        accList[i].setId(strChange);
                                        System.out.println("Đổi id thành công!");
                                        accList[i].printAccount();
                                    }
                                }
                                break;
                            case 2:
                                strChange = infoChange[1].showMenu()[0];
                                if (!strChange.trim().equals("")){
                                    if (getAccountbyId(strChange) != null){
                                        System.out.println("username mới bị trùng, không thể đổi!");
                                    } else {
                                        accList[i].setId(strChange);
                                        System.out.println("Đổi username thành công!");
                                        accList[i].printAccount();
                                    }
                                }
                                break;
                            case 3:
                                strChange = infoChange[2].showMenu()[0];
                                if (!strChange.trim().equals("")){
                                    if (getAccountbyId(strChange) != null){
                                        System.out.println("pass mới bị trùng, không thể đổi!");
                                    } else {
                                        accList[i].setId(strChange);
                                        System.out.println("Đổi pass thành công!");
                                        accList[i].printAccount();
                                    }
                                }
                                break;
                            case 4:
                                strChange = infoChange[3].showMenu()[0];
                                if (!strChange.trim().equals("")){
                                    if (getAccountbyId(strChange) != null){
                                        System.out.println("quyền mới bị trùng, không thể đổi!");
                                    } else {
                                        accList[i].setId(strChange);
                                        System.out.println("Đổi quyền thành công!");
                                        accList[i].printAccount();
                                    }
                                }
                                break;
                            case 5:
                                return;
                        }
                    }
                }
            }
            System.out.println("Không tìm thấy tài khoản!");
        }
    }

    @Override
    public void search() {
        if (accCount == 0){
            System.out.println("Danh sách tài khoản trống, không thể tìm kiếm tài khoản!");
            return;
        }
        while (true){
            int select = new MenuSelect(new String[]{
                "Tìm kiếm theo mã tài khoản",
                "Tìm kiếm theo username",
                "Quay lại",
            }).showMenu();

            String[] data;
            Account[] result = null;
            switch (select){
                case 1:
                    data = new MenuInput(new String[] {
                        "Nhập mã"
                    }).showMenu();
                    Account tmp = getAccountbyId(data[0]);
                    if (tmp != null){
                        result = new Account[1];
                        result[0] = tmp;
                        result[0].printAccount();
                    } else {
                        System.out.println("Không tìm thấy tài khoản!");
                    }
                    break;
                case 2:
                    data = new MenuInput(new String[] {
                        "Nhập username"
                    }).showMenu();
                    result = getAccountbyName(data[0]);
                    break;
                case 3:
                    return;
            }
        }            
    }

    @Override
    public void remove() {
        String[] info = new MenuInput(new String[] {
            "Nhập mã tài khoản cần xoá"
        }).showMenu();

        if (info != null){
            for (int i = 0; i < idCount; i++) {
                if (accList[i] == null) continue;
                if (accList[i].getId().equals(info[0].trim())){
                    accCount --;
                    System.out.println("Đã xóa tài khoảm" + accList[i].getUser());
                    for (int x = i; x < idCount - 1; x++) {
                        accList[x] = accList[x + 1];
                    }
                    accList[idCount - 1] = null;
                    return;
                }
            }
        }
    }

    public void read() {
        String[] data = read(file_url);
        accCount = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i] == null) continue;
            String[] tmp = data[i].split(",");
            if (getAccountbyId(tmp[0]) != null){
                System.out.println("Thêm tài khoản dòng " + (i + 1) + " không thành công (Mã tài khoản bị trùng)!");
                continue;
            }
            add(new Account(tmp[0], tmp[1], Integer.parseInt(tmp[2]), tmp[3], null));
        }
    }

    public void write() {
        write(file_url, this.accListToStrings(accList));
    }

    public Account[] getAccountbyName (String name) {
        Account[] result = new Account[100];
        int index = -1;
        for (int i = 0; i < idCount; i++){
            if (accList[i] == null) continue;
            if (((String) accList[i].getUser()).toLowerCase().indexOf(name.toLowerCase()) > -1 || ((String) accList[i].getUser()).toLowerCase().indexOf(Main.removeAccents(name.toLowerCase())) > -1){
                index ++;
                result[index] = accList[i];
            }
        }
        if (index > -1){
            System.out.println("Đã tìm thấy " + (index + 1) + " tài khoản!");
            this.show(result);
        } else {
            System.out.println("Không tìm thấy tài khoản!");
            return null;
        }
        return result;
    }

    public static Account getAccountbyId(String id){
        for (int i = 0; i < idCount; i++){
            if (accList[i] == null) continue;
            if (accList[i].getId().equals(id.trim())){
                return accList[i];
            }
            return null;
        }
        // System.out.println("Không tìm thấy tài khoản!");
        return null;
    }

    public Account[] getAccountList(){
        return accList;
    }

    public void setAccountList(Account[] accList){
        ManageAccount.accList = accList;
    }

    public String[] accListToStrings (Account[] accList){
        String[] str = new String[100];
        for (int i = 0; i < accCount; i++){
            str[i] = accList[i].toString();
        }
        return str;
    }
}
