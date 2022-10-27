import java.util.ArrayList;

class Customer {
    public int id;
    public String name;

    public String status ;

    public Customer() {
        this.status = "";
    }

    public ArrayList<Menu> buyFoods = new ArrayList<Menu>();

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public void pickUp(Menu menu) {
        this.buyFoods.add(menu);
    }

    public void payMenu(Menu menu) { this.buyFoods.remove(menu);
    }


}
