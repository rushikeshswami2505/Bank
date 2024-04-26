import java.sql.*;

public class DatabaseController {

    String DB_URL = "";
    String USER = "";
    String PASS = "";
    String DATABASENAME = "";

    DatabaseController(String DB_URL,String USER, String PASS, String DATABASENAME){
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASS = PASS;
        this.DATABASENAME = DATABASENAME;
    }

    public void CraeteDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            String sql = "CREATE DATABASE IF NOT EXISTS " + DATABASENAME;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // e.printStackTrace();
        }
    }

    public void CreateTable(String TABLENAME) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
                    String SQLSTATEMENT = "CREATE TABLE IF NOT EXISTS " + TABLENAME +
                    "(name VARCHAR(255) not NULL, " +
                    "ACCOUNT INTEGER not NULL," +
                    "ADDRESS VARCHAR(255) not NULL," +
                    "TYPE INTEGER not null," +
                    "NUMBER VARCHAR(255) not null," +
                    "DOB VARCHAR(255) not null," +
                    "AGE INTEGER not null, " +
                    "AMOUNT DECIMAL(20,2) not null)";
            stmt.executeUpdate(SQLSTATEMENT);
            // System.out.println("Created table in given database...");
        } catch (SQLException e) {
            // e.printStackTrace();
        }
    }

    public void insertNewCustomer(String TABLES_URL, String TABLENAME , BankUser bankUser) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
                String SQLSTATEMENT = "INSERT INTO " + TABLENAME +
                    " (name, userId, accountType, address, phoneNumber, dob, age, totalAmount) " +
                    "VALUES ("+bankUser.getName()+","+bankUser.getUserId()+
                    ","+bankUser.getAccountType()+","+bankUser.getAddress()+
                    ","+bankUser.getPhoneNumber()+","+bankUser.getDob()+
                    ","+bankUser.getAge()+","+bankUser.getTotalAmount()+")";    
            stmt.executeUpdate(SQLSTATEMENT);
            // System.out.println("Created table in given database...");
        } catch (SQLException e) {
            // e.printStackTrace();
        }
    }
}
