package RBIGovernor.Pune;
import AgeCalculator.AgeController;
import DataBaseJDBC.BankUser;
import RBIGovernor.BankOfIndia;

import java.util.*;

public class PuneBankController extends BankOfIndia {

    public static final String BANKNAME =  "Pune bank of India";
    public static final String BANKLOCATION =  "Pune aundh";
    public static final String IFSCCODE = "PUNE325433234";
    public static final int PINCODE = 411107;
    public int TOTALUSERS =  0;
    public String USERIDFORMAT = "PI5367";
    public static int lastId = 76456;

    PuneDatabase puneDatabase = new PuneDatabase();

    public void setBankDetails(){
        bankDetails.setBankLocation(BANKLOCATION);
        bankDetails.setBankName(BANKNAME);
        bankDetails.setIfcs(IFSCCODE);
        bankDetails.setPincode(PINCODE);
        bankDetails.setTotalClients(TOTALUSERS);
    }
    public void initializeDatabase(){
        puneDatabase.createDatabase();
        puneDatabase.createTable();
    }

    List<BankUser> bankUsers = new ArrayList<>(); 
    Scanner sc = new Scanner(System.in);
    public void userRegistration(){
        BankUser bankUser = new BankUser();  
        System.out.print("Select account type 1. Saving 2. Current(1/2): " );
        int accountType = sc.nextInt();   
        sc.nextLine();
        System.out.print("Enter name : ");
        String name = sc.nextLine();
        System.out.print("Enter address : ");
        String address = sc.nextLine();
        int [] dob = new int[3];
        System.out.print("Enter date of birth : ");
        AgeController ac = new AgeController();
        dob[0] = sc.nextInt();
        dob[1] = sc.nextInt();
        dob[2] = sc.nextInt();
        if(!ac.validDate(dob[0],dob[1],dob[2])){
            System.out.println("Please enter valid date of birth");
            return;
        }
        System.out.print("Enter phonenumber : ");
        long phone = sc.nextLong();
        double amount = 0;
        while(true){
            System.out.print("Enter amount : ");
            amount = sc.nextDouble();
            if(amount<1000) {
                System.out.println(">>>>>>>>>> Please deposite minimum 1000/-");
            } 
            else{
                break;
            }
        }
        bankUser.setName(name);
        bankUser.setAddress(address);
        bankUser.setAccountType(accountType);
        bankUser.setDob(dob);
        bankUser.setPhoneNumber(phone);    
        bankUser.setTotalAmount(amount);
        bankUser.setUserId(USERIDFORMAT+""+(lastId++));
        bankUser.setAge(ac.MyAge(dob[0],dob[1],dob[2]));
        bankDetails.setTotalClients(bankDetails.getTotalClients()+1);
        bankUsers.add(bankUser);
        puneDatabase.insertNewCustomer(bankUser);
        System.out.println("!!! New Registration added !!!");
    }

    public void userWithdral(){
        int i = getUserIndex();
        if(i==-1) return;
        System.out.print("Enter withdrawal amount : ");
        double amount = sc.nextDouble();
        BankUser bankUser = bankUsers.get(i);
        if(bankUser.getTotalAmount()>=(amount+1000)){
            bankUser.setTotalAmount(bankUser.getTotalAmount()-amount);
            bankUsers.set(i, bankUser);
            System.out.println(">>>>>>>>>> You sucessful withdraw "+amount+" amount and your remaining balance is "+bankUser.getTotalAmount());
        }else{
            System.out.println(">>>>>>>>>> Withdrawal failed");
            System.out.println(">>>>>>>>>> You can withdraw maximum"+(bankUser.getTotalAmount()-1000));
        } 
    }

    public void userDeposite(){
        int i = getUserIndex();
        if(i==-1) return;
        System.out.print("Enter deposite amount : ");
        double amount = sc.nextDouble();
        BankUser bankUser = bankUsers.get(i);
        bankUser.setTotalAmount(bankUser.getTotalAmount()+amount);
        bankUsers.set(i, bankUser);
        System.out.println(">>>>>>>>>> You sucessful deposite "+amount+" amount and now your balance is "+bankUser.getTotalAmount());
        
    }
    public void userShowUserDetailsByUserId(){
        int i = getUserIndex();
        if(i==-1) return;
        BankUser bankUser = bankUsers.get(i);
        System.out.println(bankUser.toString());
    }

    public void userShowUserDetails(){
        puneDatabase.selectAllAccounts();
        // System.out.println("------------------------------------------------------------------------------------------------------");
        // System.out.printf("%10s %15s %15s %5s %15s %10s %5s %10s","NAME","ACCOUNT","ADDRESS","TYPE","NUMBER","DOB","AGE","TOTAL AMOUNT");
        // System.out.println("\n------------------------------------------------------------------------------------------------------");
        // for(int i=0;i<bankUsers.size();i++){
        //     BankUser bankUser = bankUsers.get(i);
        //     System.out.printf("%10s %15s %15s %5s %15s %10s %5s %10s\n",bankUser.getName(),bankUser.getUserId(),bankUser.getAddress(),bankUser.getAccountType(),bankUser.getPhoneNumber(),bankUser.getDob(),bankUser.getAge(),bankUser.getTotalAmount());
        // }
        // System.out.println("\n------------------------------------------------------------------------------------------------------");
        
    }
    private int getUserIndex(){
        int i = 0;
        System.out.print("Enter user ID : ");
        String userId = sc.next();
        
        for(i=0;i<bankUsers.size();i++){
            if(bankUsers.get(i).getUserId().equals(userId)){
                return i;
            }
        }
        if(i==bankUsers.size()) System.out.println(">>>>>>>>>> User not found");
        return -1;
    }
}

// PI536786323476456