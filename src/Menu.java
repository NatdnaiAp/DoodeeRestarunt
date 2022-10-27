class Menu {
    public int id;
    public int price;
    public String namef;
    public String status;

    public Menu() {
        this.status = " (Can Order)";


    }

    public Menu(int id, String namef, int price) {
        this.id = id;
        this.namef = namef;
        this.price = price;
    }
}
