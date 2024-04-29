package DataBaseJDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    String DB_URL = "";
    String USER = "";
    String PASS = "";
    String DATABASENAME = "";
    String TABLES_URL = "";

    public DatabaseController(String DB_URL,String USER, String PASS, String DATABASENAME){
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASS = PASS;
        this.DATABASENAME = DATABASENAME;
        this.TABLES_URL = DB_URL + DATABASENAME;
    }

    public void craeteDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            String sql = "CREATE DATABASE IF NOT EXISTS " + DATABASENAME;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String accounttable) {
        try (Connection conn = DriverManager.getConnection(TABLES_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
                    String sql = "CREATE TABLE IF NOT EXISTS " + accounttable +
                    "(NAME VARCHAR(255) not NULL, " +
                    "USERID VARCHAR(255) not NULL, "+
                    "ACCOUNTTYPE INTEGER not NULL," +
                    "ADDRESS VARCHAR(255) not NULL," +
                    "PHONENUMBER VARCHAR(255) not null," +
                    "DOB VARCHAR(255) not null," +
                    "AGE INTEGER not null, " +
                    "TOTALAMOUNT DECIMAL(20,2) not null)";
            stmt.executeUpdate(sql);
            // System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewCustomer(String accounttable, BankUser bankUser) {
        try (Connection conn = DriverManager.getConnection(TABLES_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO " + accounttable + " (name, userId, accountType, address, phoneNumber, dob, age, totalAmount) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");) {
            pstmt.setString(1, bankUser.getName());
            pstmt.setString(2, bankUser.getUserId());
            pstmt.setInt(3, bankUser.getAccountType());
            pstmt.setString(4, bankUser.getAddress());
            pstmt.setLong(5, bankUser.getPhoneNumber());
            pstmt.setString(6, bankUser.getDob());
            pstmt.setInt(7, bankUser.getAge());
            pstmt.setDouble(8, bankUser.getTotalAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public void selectAllAccounts(String accounttable) {
    //     try(Connection conn = DriverManager.getConnection(TABLES_URL, USER, PASS);
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery("SELECT name, userId, accountType, address, phoneNumber, dob, age, totalAmount FROM "+accounttable)){
    //             System.out.println("------------------------------------------------------------------------------------------------------");
    //             System.out.printf("%10s %15s %15s %5s %15s %10s %5s %10s","NAME","ACCOUNT","ADDRESS","TYPE","PHONE NUMBER","DOB","AGE","TOTAL AMOUNT");
    //             System.out.println("\n------------------------------------------------------------------------------------------------------");        
    //             while (rs.next()) {
    //                 String accountType = rs.getInt("accountType")==1? "Saving" : "Current";
    //                 System.out.printf("%10s %15s %15s %5s %15s %10s %5s %10s\n",rs.getString("name"),rs.getString("userId"),accountType,rs.getString("address"),rs.getString("phoneNumber"),rs.getString("dob"),rs.getInt("age"),rs.getDouble("totalAmount"));    
    //             }
    //             System.out.println("\n------------------------------------------------------------------------------------------------------");
                
    //     }
    //     catch (Exception e) {
    //         e.printStackTrace();        
    //     }
    // }

    public void withdrawAmount(String accounttable, String userId, double amount) {
        String sql = "UPDATE " + accounttable + " SET TOTALAMOUNT = (TOTALAMOUNT - ?) WHERE USERID = ?";
        try (Connection conn = DriverManager.getConnection(TABLES_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
            System.out.println("!!! Data update !!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void depositeAmount(String accounttable, String userId, double amount) {
        String sql = "UPDATE " + accounttable + " SET TOTALAMOUNT = (TOTALAMOUNT + ?) WHERE USERID = ?";
        try (Connection conn = DriverManager.getConnection(TABLES_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
            System.out.println("!!! Data update !!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    public List<BankUser> getAllUser(String accounttable) {
        try(Connection conn = DriverManager.getConnection(TABLES_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, userId, accountType, address, phoneNumber, dob, age, totalAmount FROM "+accounttable)){
                List<BankUser> list = new ArrayList<>();
                while (rs.next()) {
                    BankUser bankUser = new BankUser();
                    bankUser.setName(rs.getString("name"));
                    bankUser.setUserId(rs.getString("userId"));
                    bankUser.setAccountType(rs.getInt("accountType"));
                    bankUser.setAddress(rs.getString("address"));
                    bankUser.setDob(rs.getString("dob"));
                    bankUser.setAge(rs.getInt("age"));
                    bankUser.setTotalAmount(rs.getDouble("totalamount"));
                    list.add(bankUser);
                }
                return list;
        }  
        catch (Exception e) {
            e.printStackTrace();        
        }
        return null;
    }

      
}
