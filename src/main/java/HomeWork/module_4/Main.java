package HomeWork.module_4;

public class Main {
    public static void main(String[] args) {
        MySQL_DBConnection mySQLcon = new MySQL_DBConnection();
        PostgreSQL_DBConnection postGreCon = new PostgreSQL_DBConnection();
        DBQuery dbQuery = new DBQuery();
        dbQuery.isConnected(mySQLcon.getDBConnection());
        dbQuery.isConnected(postGreCon.getDBConnection());
        dbQuery.CreateTableUsers(mySQLcon.getDBConnection());
        dbQuery.CreateTableItems(mySQLcon.getDBConnection());
        dbQuery.CreateTableOrders(mySQLcon.getDBConnection());
        dbQuery.addUsersDate(mySQLcon.getDBConnection(), "John", "some_pass");
        dbQuery.addUsersDate(mySQLcon.getDBConnection(), "Alex", "some_pass");

        dbQuery.addItemsDate(mySQLcon.getDBConnection(), "Кружка мужская", 300, "cups");
        dbQuery.addItemsDate(mySQLcon.getDBConnection(), "Кепка красная", 150, "hats");
        dbQuery.addItemsDate(mySQLcon.getDBConnection(), "Кепка синяя", 300, "hats");
        dbQuery.addItemsDate(mySQLcon.getDBConnection(), "Кружка женская", 300, "cups");
        dbQuery.addItemsDate(mySQLcon.getDBConnection(), "Красная фуболка", 300, "shirts");
        dbQuery.addItemsDate(mySQLcon.getDBConnection(), "Футболка \"Рик и Морти\"", 300, "shirts");

        dbQuery.addOrderDate(mySQLcon.getDBConnection(), 1,3);
        dbQuery.addOrderDate(mySQLcon.getDBConnection(), 1,2);
        dbQuery.addOrderDate(mySQLcon.getDBConnection(), 2,1);
        dbQuery.addOrderDate(mySQLcon.getDBConnection(), 2,4);
        dbQuery.addOrderDate(mySQLcon.getDBConnection(), 2,5);
        dbQuery.addOrderDate(mySQLcon.getDBConnection(), 2,6);

        dbQuery.getData(mySQLcon.getDBConnection());
    }
}
