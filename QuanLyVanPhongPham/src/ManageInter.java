interface ManageInter {
    String[] menuStr = {"Quản lý khách hàng", "Quản lý hàng hoá", "Quản lý vận chuyển"};
    MenuSelect menu = new MenuSelect(4, menuStr);
    public static void add(){};
    public static void edit(){};
    public static void delete(){};
    public static void search(){};
    public static void show(){};
}
