interface ManageInter {
    String[] menuStr = {"Quản lý khách hàng", "Quản lý hàng hoá", "Quản lý vận chuyển"};
    MenuSelect menu = new MenuSelect(4, menuStr);
    public void add();
    public void edit();
    public void delete();
    public void search();
    public void show();
}
