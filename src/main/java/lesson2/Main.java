package lesson2;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) throws SQLException {
        try {
            createNewDB();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        clearTable();
        createListOfGoods();
        selectGood();
        changePrice();
        selectGoodBetweenPrice();
        disconnect();
    }

    private static void clearTable() throws SQLException {
        stmt.execute("DELETE FROM goods");
        System.out.println("Table is empty!");
    }

    private static void createNewDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/goodsDN.db");
        stmt = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS goods (\n" +
                "good_id integer PRIMARY KEY,\n" +
                "good_name VARCHAR NOT NULL,\n" +
                "good_price double NOT NULL" +
                ");";
        stmt.execute(sql);
        System.out.println("New Data Base was created!");
    }

    private static void createListOfGoods() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            stmt.addBatch(String.format("INSERT INTO Goods (good_id, good_name, good_price) VALUES ('%s', 'good%s', '%s')", i, i, Math.abs(5000 - i)));
        }
        stmt.executeBatch();
        connection.setAutoCommit(true);
        System.out.println("New 10000 goods in table!");
    }

    private static void selectGood() {
        while (true) {
            String name;
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Price of witch good will you know?");
            name = scanner.nextLine();
            try {
                rs = stmt.executeQuery(String.format("SELECT good_price FROM goods WHERE good_name = '%s'", name));
                String price = rs.getString("good_price");
                System.out.println("Price of this good is " + price);
            } catch (SQLException throwables) {
                System.out.println("There are no goods in DB with this name!");
            }
            System.out.println("Do you want to find another good? y/n");
            String answer = scanner.nextLine();
            if (answer.equals("n")) return;

        }
    }

    private static void changePrice() {
        while (true) {
            String name;
            String price;
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Price of witch good want you change?");
            name = scanner.nextLine();
            System.out.println("Put in new price:");
            price = scanner.nextLine();
            try {
                stmt.executeUpdate(String.format("UPDATE goods SET good_price = '%s' WHERE good_name = '%s'", price, name));
                rs = stmt.executeQuery(String.format("SELECT good_price FROM Goods WHERE good_name = '%s'", name));
                String newPrice = rs.getString("good_price");
                System.out.println("Price of this good for NOW is " + newPrice);
            } catch (SQLException throwables) {
                System.out.println("Wrong name or price of good!");
            }
            System.out.println("Do you want to change price of another good? y/n");
            String answer = scanner.nextLine();
            if (answer.equals("n")) return;
        }
    }

    private static void selectGoodBetweenPrice() {
        while (true) {
            String price1;
            String price2;
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("In what price range are goods needed");
            price1 = scanner.nextLine();
            price2 = scanner.nextLine();
            try {
                rs = stmt.executeQuery(String.format("SELECT good_name, good_price FROM goods WHERE good_price BETWEEN '%s' AND '%s';", price1, price2));

                System.out.println("List of goods");
                while (rs.next()) {
                    System.out.println(rs.getString("good_name") + " costs " + rs.getString("good_price"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Do you want to find another goods? y/n");
            String answer = scanner.nextLine();
            if (answer.equals("n")) return;

        }
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

}
