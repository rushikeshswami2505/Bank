import java.io.*;
import java.sql.*;
public class PuneDatabase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "root";
    static final String DATABASENAME = "punedatabase";
    static final String TABLENAME = "accounts";
    static final String TABLES_URL = "jdbc:mysql://localhost:3306/"+DATABASENAME;
    DatabaseController databaseController = new DatabaseController(DB_URL,USER,PASS,DATABASENAME);

    BankUser bankUser;

    public void CreateDatabase(){
        databaseController.CraeteDatabase();
    }

    public void CreateTable(){
        databaseController.CreateTable(TABLENAME);
    }

    public void insertNewCustomer(BankUser bankUser) {
        this.bankUser = bankUser;
        databaseController.insertNewCustomer(TABLES_URL,TABLENAME,bankUser);
    }
}
