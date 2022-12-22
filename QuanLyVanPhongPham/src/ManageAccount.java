public class ManageAccount extends Manager {
    private Account[] accList = new Account[100];
    private String file_url = "DSTK.txt";
    private int accCount = 0;

    public static String[] roleName = {
        "Quản trị",
        "Nhân viên",
        "Khách hàng"
    };


    public void main() {
        while (true) {
            MenuSelect menu = new MenuSelect(new String[] {
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
            if (getMethod(select) == -1)
                return;
        }
    }

    @Override
    public void show() {
        if (Main.role == 0)
            show(accList);
        else {
            Account[] tmp = new Account[accCount];
            int count = -1;
            for (Account ele : accList) {
                if (ele == null)
                    break;
                if (ele.getRole() == 2) {
                    System.out.println(ele.getUser());
                    count++;
                    tmp[count] = ele;
                }
            }
            show(tmp);
        }
    }

    public void show(Account[] acc) {
        if (acc[0] == null) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.printf("\t\t\t    %-20s    \t\t\t\n", "DANH SÁCH TÀI KHOẢN");
        for (int i = 0; i < 73; i++)
            System.out.print("=");
        System.out.println();
        System.out.printf("|%-7s|%-7s|%-25s|%-14s|%-14s|\n", "STT", "ID", "Họ Tên", "Tài khoản", "Quyền");
        for (int i = 0; i < 73; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < acc.length; i++) {
            if (acc[i] == null)
                break;
            System.out.printf("|%-7s|%-7s|%-25s|%-14s|%-14s|\n", i, acc[i].getId(), acc[i].getInfo().getName(),acc[i].getUser(), roleName[acc[i].getRole()]);
        }
        for (int i = 0; i < 73; i++)
            System.out.print("=");
        System.out.println();
    }

    @Override
    public void add() {
        if (Main.role == 0){
            while (true) {
                int select = new MenuSelect(new String[] {
                        "Tạo tài khoản admin",
                        "Tạo tài khoản nhân viên",
                        "Tạo tài khoản khách hàng",
                        "Quay lại"
                }).showMenu();
    
                if (select == 4)
                    return;
    
                String[] info = new MenuInput(new String[] {
                        "Nhập mã tài khoản",
                        "Nhập tài khoản",
                        "Nhập mật khẩu",
                        "Nhập họ",
                        "Nhập tên",
                        "Nhập năm sinh (dd/mm/yyyy)",
                        "Nhập số điện thoại"
                }).showMenu();
    
                if (info == null)
                    return;
    
                if (getAccountbyId(info[0], 0) != null) {
                    System.out.println("Mã tài khoản bị trùng!");
                    continue;
                }
    
                accCount++;
                accList[accCount - 1] = new Account(info[0], info[1], info[2], select - 1, info[3], info[4],
                        Date.createDateFromString(info[5]), info[6]);
                System.out.println("Tạo tài khoản thành công!");
                accList[accCount - 1].printAccount();
            }
        }else {
            while (true){
                int select = new MenuSelect(new String[] {
                    "Tạo tài khoản khách hàng",
                    "Quay lại"
            }).showMenu();

            if (select == 2)
                return;

            String[] info = new MenuInput(new String[] {
                    "Nhập mã tài khoản",
                    "Nhập tài khoản",
                    "Nhập mật khẩu",
                    "Nhập họ",
                    "Nhập tên",
                    "Nhập năm sinh (dd/mm/yyyy)",
                    "Nhập số điện thoại"
            }).showMenu();

            if (info == null)
                return;

            if (getAccountbyId(info[0], 0) != null) {
                System.out.println("Mã tài khoản bị trùng!");
                continue;
            }

            accCount++;
            accList[accCount - 1] = new Account(info[0], info[1], info[2], 2, info[3], info[4],
                    Date.createDateFromString(info[5]), info[6]);
            System.out.println("Tạo tài khoản thành công!");
            accList[accCount - 1].printAccount();
            }
        }
    }

    public void add(Account acc) {
        accCount++;
        accList[accCount - 1] = acc;
    }

    @Override
    public void edit() {
        while (true) {
            if (accCount <= 0) {
                System.out.println("Danh sách tài khoản trống, không thể sửa tài khoản");
                return;
            }
            String[] info = new MenuInput(new String[] {
                    "Nhập mã tài khoản cần sửa"
            }).showMenu();

            if (info == null)
                return;

            for (int i = 0; i < accCount; i++) {
                if (accList[i].getId().equals(info[0].trim())) {
                    if (Main.role != 0 && accList[i].getRole() != 2)
                        break;
                    while (true) {
                        int select = new MenuSelect(new String[] {
                                "Thay đổi username",
                                "Thay đổi pass",
                                "Thay đổi quyền",
                                "Quay lại",
                        }).showMenu();

                        if (select == -1) continue;
                        if (select == 4) return;

                        MenuInput[] infoChange = new MenuInput[10];
                        infoChange[1] = new MenuInput(new String[] {
                            "username cũ: " + accList[i].getUser() + "\nusername mới"
                        });

                        infoChange[2] = new MenuInput(new String[] {
                            "pass mới"
                        });

                        infoChange[3] = new MenuInput(new String[] {
                            "quyền cũ: " + roleName[accList[i].getRole()] + "\nquyền mới (0/1/2)"
                        });

                        String tmp[] = infoChange[select].showMenu();
                        if (tmp == null) continue;
                        String strChange = tmp[0];
                        switch (select) {
                            case 1:
                                if (!strChange.trim().equals("")) {
                                    if (getAccountByUser(strChange, 0) != null) {
                                        System.out.println("username mới bị trùng, không thể đổi!");
                                    } else {
                                        accList[i].setUser(strChange);
                                        System.out.println("Đổi username thành công!");
                                        accList[i].printAccount();
                                    }
                                }
                                break;
                            case 2:
                                accList[i].setPass(strChange);
                                System.out.println("Đổi pass thành công!");
                                accList[i].printAccount();
                                break;
                            case 3:
                                accList[i].setRole(Integer.parseInt(strChange));
                                System.out.println("Đổi quyền thành công!");
                                accList[i].printAccount();
                                break;
                        }
                    }
                }
            }
            System.out.println("Không tìm thấy tài khoản!");
        }
    }

    @Override
    public void search() {
        if (accCount == 0) {
            System.out.println("Danh sách tài khoản trống, không thể tìm kiếm tài khoản!");
            return;
        }
        while (true) {
            int select = new MenuSelect(new String[] {
                    "Tìm kiếm theo mã tài khoản",
                    "Tìm kiếm theo username",
                    "Quay lại",
            }).showMenu();


            if (select == -1)
                continue;

            String[] data;
            switch (select) {
                case 1:
                    data = new MenuInput(new String[] {
                            "Nhập mã"
                    }).showMenu();
                    Account tmp = getAccountbyId(data[0], Main.role);
                    if (tmp != null) {
                        tmp.printAccount();
                    } else {
                        System.out.println("Không tìm thấy tài khoản!");
                    }
                    break;
                case 2:
                    data = new MenuInput(new String[] {
                            "Nhập username"
                    }).showMenu();
                    getAccountbyName(data[0], Main.role);
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

        if (info == null) return;
        for (int i = 0; i < accCount; i++) {
            // if (accList[i] == null)
            //     continue;
            if (accList[i].getId().equals(info[0].trim())) {
                if (Main.role != 0 && accList[i].getRole() != 2)
                    break;
                System.out.println("Đã xóa tài khoản " + accList[i].getUser());
                // System.err.println(i + " " + (accCount - 1));
                for (int x = i; x < accCount - 1; x++) {
                    accList[x] = accList[x + 1];
                }
                accList[accCount - 1] = null;
                accCount--;
                return;
            }
        }
        System.out.println("Không tìm thấy tài khoản");
    }

    public void read() {
        String[] data = read(file_url);
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null)
                continue;
            String[] info = data[i].split(",");

            if (info.length < 8){
                System.out.println("Thêm tài khoản dòng " + (i + 1)
                + " không thành công! (Dòng dữ liệu sai)");
                continue;
            }

            if (Main.role != 0 && Integer.parseInt(info[3]) != 2){
                System.out.println("Thêm tài khoản dòng " + (i + 1) + " không thành công! (Không có quyền thêm)");
                continue;
            }

            if (getAccountbyId(info[0], 0) != null) {
                System.out.println("Thêm tài khoản dòng " + (i + 1)
                        + " không thành công! (Mã tài khoản bị trùng)");
                continue;
            }
            add(new Account(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4], info[5], Date.createDateFromString(info[6]), info[7]));
        }
    }

    public void write() {
        write(file_url, this.accListToStrings(accList));
    }

    public Account[] getAccountbyName(String name, int role) {
        Account[] result = new Account[100];
        int index = -1;
        for (int i = 0; i < accCount; i++) {
            if (accList[i] == null)
                continue;
            if (((String) accList[i].getUser()).toLowerCase().indexOf(name.toLowerCase()) > -1
                    || ((String) accList[i].getUser()).toLowerCase()
                            .indexOf(Main.removeAccents(name.toLowerCase())) > -1) {
                if (role != 0 && accList[i].getRole() != 2){
                    // System.out.println("Tìm thấy tài khoản nhưng không có quyền xem");
                    continue;
                }
                index++;
                result[index] = accList[i];
            }
        }
        if (index > -1) {
            System.out.println("Đã tìm thấy " + (index + 1) + " tài khoản!");
            this.show(result);
        } else {
            System.out.println("Không tìm thấy tài khoản!");
            return null;
        }
        return result;
    }

    public Account getAccountbyId(String id, int role) {
        for (int i = 0; i < accCount; i++) {
            if (accList[i] == null)
                continue;
            if (accList[i].getId().equals(id.trim())) {
                if (role != 0 && accList[i].getRole() != 2){
                    // System.out.println("Tìm thấy tài khoản nhưng không có quyền xem");
                    return null;
                }
                return accList[i];
            }
        }
        // System.out.println("Không tìm thấy tài khoản!");
        return null;
    }
    public Account getAccountByUser(String user, int role) {
        for (int i = 0; i < accCount; i++) {
            if (accList[i] == null)
                continue;
            if (accList[i].getUser().equals(user.trim())) {
                if (role != 0 && accList[i].getRole() != 2){
                    // System.out.println("Tìm thấy tài khoản nhưng không có quyền xem");
                    return null;
                }
                return accList[i];
            }
        }
        // System.out.println("Không tìm thấy tài khoản!");
        return null;
    }

    public Account[] getAccountList() {
        return accList;
    }

    public String[] accListToStrings(Account[] accList) {
        String[] str = new String[100];
        for (int i = 0; i < accList.length; i++) {
            if (accList[i] ==  null) break;
            str[i] = accList[i].toString();
        }
        return str;
    }
}
