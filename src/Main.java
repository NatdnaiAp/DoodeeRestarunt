import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
class Main {

        static  Scanner scan  = new Scanner(System.in);
        static Restarunt restarunt = new Restarunt();




        public static void main(String[] args) {
            initLibraryData();

            String isContinue = "y";

            while(isContinue.equals("y")){
                showMenu();
                int selectedMenu = chooseMenu();

                if (selectedMenu == 1) {
                    showMenues();
                } else if (selectedMenu == 2) {
                    showCustomer();
                } else if (selectedMenu == 3) {
                    addCustomer();
                } else if (selectedMenu == 4) {
                    pickFood();
                } else if (selectedMenu == 5) {
                    payBills();
                } else if (selectedMenu == 6) {
                    removeCustomer();
                }
                else {
                    System.out.println("wrong input");
                }

                System.out.print("continue ? ");
                isContinue = scan.next();
            }
        }
        public static void showMenu() {
            System.out.println("================================");
            System.out.println("       DooDee Restaurant :");
            System.out.println("1. show MENU list");
            System.out.println("2. show Customer list");
            System.out.println("3. add Customer");
            System.out.println("4. Buy Food");
            System.out.println("5. Pay Bills");
            System.out.println("6. remove Customer");
            System.out.println("================================");
        }


        public static void initLibraryData() {
            Menu menu1 = new Menu();
            menu1.id = 1;
            menu1.namef = "ข้าวผัดกะเพราหมู";
            menu1.price = 50;



            Menu menu2= new Menu();
            menu2.id = 2;
            menu2.namef = "ก๋วยเตี๊ยวน้ำตกหมู";
            menu2.price = 60;


            Menu menu3 = new Menu();
            menu3.id = 3;
            menu3.namef = "ส้มตำไทไข่เค็ม";
            menu3.price = 45;

            Menu menu4 = new Menu();
            menu4.id = 4;
            menu4.namef = "ข้าวมันไก่";
            menu4.price = 45;


            Menu menu5 = new Menu();
            menu5.id = 5;
            menu5.namef = "ข้าวหมูกรอบ";
            menu5.price = 55;

            Menu menu6 = new Menu();
            menu6.id = 6;
            menu6.namef = "ข้าวไข่เจียว";
            menu6.price = 30;


            Customer customer1 = new Customer();
            customer1.id = 1;
            customer1.name = "Somchai";

            Customer customer2 = new Customer();
            customer2.id = 2;
            customer2.name = "Somphong";

            Customer customer3 = new Customer();
            customer3.id = 3;
            customer3.name = "Paserd";

            restarunt.menues.add(menu1);
            restarunt.menues.add(menu2);
            restarunt.menues.add(menu3);
            restarunt.menues.add(menu4);
            restarunt.menues.add(menu5);
            restarunt.menues.add(menu6);


            restarunt.customers.add(customer1);
            restarunt.customers.add(customer2);
            restarunt.customers.add(customer3);
        }


        public static int chooseMenu() {
            System.out.print("choose menu : ");
            int pilihan = scan.nextInt();
            return pilihan;

        }
        public static void showMenues() {
            for (Menu menu : restarunt.menues) {
                System.out.println(menu.id + " " + menu.namef+" "+menu.price+" Bath"+""+menu.status);
            }
        }

        public static void payBills(){

            System.out.print("id member : ");
            Integer customerId = scan.nextInt();

            Integer menuId = 1;


            System.out.println(restarunt.payFood(menuId, customerId)+" Bath");
        }
    public static void pickFood() {
        System.out.print("id member : ");
        Integer memberId = scan.nextInt();

        System.out.print("id menu : ");
        Integer menuId = scan.nextInt();

        restarunt.pickUp(menuId, memberId);

    }
    public static void addCustomer() {
        Customer customer = new Customer();

        System.out.print("id : ");
        customer.id = scan.nextInt();

        System.out.print("name : ");
        customer.name = scan.next();

        restarunt.addCustomer(customer);
    }

    public static void removeCustomer() {
        Customer customer = new Customer();

        System.out.print("id : ");
        customer.id = scan.nextInt();

        System.out.print("name : ");
        customer.name = scan.next();


        restarunt.removeCustomer(customer,customer.id);
    }

    public static void showCustomer() {
        for (Customer customer : restarunt.customers) {
            System.out.println(customer.id + " " + customer.name+""+customer.status);

        }
    }


}