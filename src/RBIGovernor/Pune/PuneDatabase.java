package RBIGovernor.Pune;

import DataBaseJDBC.BankUser;
import DataBaseJDBC.DatabaseController;
public class PuneDatabase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "root";
    static final String DATABASENAME = "punedatabase";
    static final String ACCOUNTTABLE = "accounts";
    static final String TABLES_URL = "jdbc:mysql://localhost:3306/"+DATABASENAME;

    DatabaseController databaseController = new DatabaseController(DB_URL,USER,PASS,DATABASENAME);

    BankUser bankUser;

    public void createDatabase(){
        databaseController.craeteDatabase();
    }

    public void createTable(){
        databaseController.createTable(ACCOUNTTABLE);
    }

    public void insertNewCustomer(BankUser bankUser) {
        this.bankUser = bankUser;
        databaseController.insertNewCustomer(ACCOUNTTABLE,bankUser);
    }

    public void selectAllAccounts() {
        databaseController.selectAllAccounts(ACCOUNTTABLE);
    }
}
