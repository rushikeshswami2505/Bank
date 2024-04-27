package RBIGovernor;
public abstract class BankOfIndia {

    public BankDetails bankDetails = new BankDetails();

    public abstract void setBankDetails();

    public abstract void userRegistration();
    public abstract void userWithdral();
    public abstract void userDeposite();
    public abstract void userShowUserDetailsByUserId();
    public abstract void userShowUserDetails();
}