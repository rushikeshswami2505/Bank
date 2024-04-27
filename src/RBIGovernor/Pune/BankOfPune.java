package RBIGovernor.Pune;
import java.util.Scanner;

public class BankOfPune extends PuneBankController{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankOfPune bankOfPune = new BankOfPune();
        bankOfPune.setBankDetails();
        bankOfPune.initializeDatabase();
        System.out.println("*****************************************************************************");
        System.out.println("*************************Welcome to bank of pune*****************************");
        System.out.println("*****************************************************************************");
        while(true){
            System.out.println("1. Add new registration"+
                               "\n2. Deposite Money"+
                               "\n3. Withdrawal money"+
                               "\n4. Show all users"+
                               "\n5. Show user by account number"+
                               "\n6. Close");
            System.out.print("Select any above options : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bankOfPune.userRegistration();
                    break;
                case 2:
                    bankOfPune.userDeposite();
                    break;
                case 3:
                    bankOfPune.userWithdral();
                    break;
                case 4:
                    bankOfPune.userShowUserDetails();
                    break;
                case 5:
                    bankOfPune.userShowUserDetailsByUserId();
                    break;    
                case 6:
                    System.out.println("!!! System closed see you tomorro !!!");
                    return;
                default:
                    System.out.println(">>>>>>>>>> Please select between 1-5");
                    break;
            }
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        }
    }

    // public void setBankDetails(){
        // bankDetails.setBankName("Pune bank of India");
        // bankDetails.setBankLocation("Pune Aundh  411107");
        // bankDetails.setTotalClients(0);
    // }
}
