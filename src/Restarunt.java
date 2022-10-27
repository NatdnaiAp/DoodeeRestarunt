
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
    public int payFood(int customerId){

        Customer customer = this.getCustomerById(customerId);

        int total = 0;
        for(Menu menu: customer.buyFoods){

            total += menu.price;
        }
        return total;

    }
    public void pickUp(int menuId,int customerId){
        Menu menu = getMenuById(menuId);
        Customer customer = getCustomerById(customerId);
        /*menu.status = " choose by "+customer.name;*/
        /*customer.status= " choose menu "+menu.namef;*/
        customer.buyFoods.add(menu);
//    this.books.remove(book);
        //Member member = this.getMemberById(memberId);
        /*int customerIndex = getCustomerIndex(customer);
        customers.get(customerIndex).buyFoods.add(menu);*/
    }
    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.id == id) {
                return customer;
            }
        }
        return null;
    }

    public Menu getMenuById(int id) {
        for (Menu menu : menues) {
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
