
import java.util.ArrayList;

class Restarunt {
    public ArrayList<Menu> menues = new ArrayList<Menu>();
    public ArrayList<Customer> customers= new ArrayList<Customer>();

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
    public void removeCustomer(Customer customer,int id){
        this.customers.remove(id);
    }
    public int payFood(int menuId,int customerId){
        Menu menu = this.getMenuById(menuId);
        Customer customer = this.getCustomerById(customerId);

        int total = 0;
        for(Menu price : customer.buyFoods){

            total += menu.price;
        }
        return total;

    }
    public void pickUp(int menuId,int customerId){
        Menu menu = this.getMenuById(menuId);
        Customer customer = this.getCustomerById(customerId);
        menu.status = " choose by "+customer.name;
        customer.status= " choose menu "+menu.namef;


//    this.books.remove(book);


        //Member member = this.getMemberById(memberId);
        int customerIndex = this.getCustomerIndex(customer);
        this.customers.get(customerIndex).buyFoods.add(menu);
    }
    public Customer getCustomerById(int id) {
        for (Customer customer : this.customers) {
            if (customer.id == id) {
                return customer;
            }
        }
        return null;
    }

    public Menu getMenuById(int id) {
        for (Menu menu : this.menues) {
            if (menu.id == id) {
                return menu;
            }
        }
        return null;
    }
    public int getCustomerIndex(Customer customer) {
        return this.customers.indexOf(customer);
    }


}
