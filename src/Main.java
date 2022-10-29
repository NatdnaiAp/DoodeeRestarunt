import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

class Main {

        public static  Scanner scan  = new Scanner(System.in);
        public static Restarunt restarunt = new Restarunt();

        public static void main(String[] args) {


            String isContinue = "y";

            while(isContinue.equals("y")){
                showMenu();
                int selectedMenu = chooseMenu();

                if (selectedMenu == 1) {
                    getAllMenu();
                } else if (selectedMenu == 2) {
                    getAllCustomer();

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
            System.out.println("1. Show Menu List");
            System.out.println("2. Show Customer List");
            System.out.println("3. Add Customer");
            System.out.println("4. Buy Food");
            System.out.println("5. Pay Bills");
            System.out.println("6. Cancel Ordered");
            System.out.println("================================");


        }



        public static int chooseMenu() {
            System.out.print("choose menu : ");
            int pilihan = scan.nextInt();
            return pilihan;
        }
        public static void payBills(){
            removeCustomer();
            System.out.print("Confirm ID For Pay Bills : ");
            int customerId = scan.nextInt();



            System.out.println(restarunt.payFood(customerId)+" บาท");

        }
    public static void pickFood() {
        try
        {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
                    + GlobalData.DATABASE_DATABASE_NAME;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, GlobalData.DATABASE_USERNAME,
                    GlobalData.DATABASE_PASSWORD);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Menu ";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String namef = rs.getString("namef");
                int price = rs.getInt("price");


                Menu mu = new Menu(id, namef,price);
                restarunt.menues.add(mu);

                // print the results

            }
            st.close();
        } catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        try
        {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
                    + GlobalData.DATABASE_DATABASE_NAME;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, GlobalData.DATABASE_USERNAME,
                    GlobalData.DATABASE_PASSWORD);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Customer ";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");


                Customer cc = new Customer(id, name);
                restarunt.customers.add(cc);

                // print the results

            }
            st.close();
        } catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }



        System.out.print("id member : ");
        int memberId = scan.nextInt();

        System.out.print("id menu : ");
        int menuId = scan.nextInt();

        restarunt.pickUp(menuId, memberId);

    }
    public static void addCustomer() {

        System.out.print("id : ");
        int id = scan.nextInt();

        System.out.print("name : ");
        String name = scan.next();
        Customer customer = new Customer(id,name);
        try
        {

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
                    + GlobalData.DATABASE_DATABASE_NAME;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, GlobalData.DATABASE_USERNAME,
                    GlobalData.DATABASE_PASSWORD);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "INSERT INTO Customer VALUES('" +customer.id+ "', '" + customer.name + "' ) ";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.executeUpdate(query);


            // iterate through the java resultset

            st.close();
        } catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }



    }

    public static void removeCustomer() {
        Customer customer = new Customer();

        System.out.print("id : ");
        customer.id = scan.nextInt();

        /*System.out.print("name : ");
        customer.name = scan.next();*/


       /* restarunt.removeCustomer(customer,customer.id);*/

        try
        {

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
                    + GlobalData.DATABASE_DATABASE_NAME;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, GlobalData.DATABASE_USERNAME,
                    GlobalData.DATABASE_PASSWORD);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "DELETE FROM Customer WHERE id = " + customer.id + " ";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.executeUpdate(query);

            // iterate through the java resultset

            st.close();
        } catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }



    public static ArrayList<Customer> getAllCustomer()
    {



        try
        {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
                    + GlobalData.DATABASE_DATABASE_NAME;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, GlobalData.DATABASE_USERNAME,
                    GlobalData.DATABASE_PASSWORD);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Customer ";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");


                Customer cc = new Customer(id, name);
                restarunt.customers.add(cc);

                // print the results
                System.out.format("%s. คุณ %s   \n", id, name );
            }
            st.close();
        } catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return restarunt.customers;
    }
    public static ArrayList<Menu> getAllMenu()
    {



        try
        {
            // create our mysql database connection
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
                    + GlobalData.DATABASE_DATABASE_NAME;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, GlobalData.DATABASE_USERNAME,
                    GlobalData.DATABASE_PASSWORD);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Menu ";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String namef = rs.getString("namef");
                int price = rs.getInt("price");


                Menu mu = new Menu(id, namef,price);
                restarunt.menues.add(mu);

                // print the results
                System.out.format("เมนูที่ %s. %s  %s บาท \n", id, namef, price);
            }
            st.close();
        } catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return restarunt.menues;
    }


}