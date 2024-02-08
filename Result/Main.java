import DataBase.*;
public class Main {
    public static void main(String[] args) {
        database database = new database();
        Menu menu = new Menu(database);
        menu.displayMenu();
    }
}