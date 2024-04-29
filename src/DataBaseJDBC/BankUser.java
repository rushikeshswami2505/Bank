package DataBaseJDBC;;

public class BankUser {
    private String name; // 1 
    private String userId; 
    private int accountType; // 2
    private String address; // 3
    private long phoneNumber; // 4
    private String dob; // 5
    private int age;
    private double totalAmount; // 6

    @Override
    public String toString() {
        return "Name : "+name+
                           "\nUser Id : "+userId+
                           "\nAddress : "+address+
                           "\nAccount Type : "+accountType+
                           "\nPhone numbe : "+phoneNumber+
                           "\nDate of birth : "+dob+
                           "\nAge : "+age+
                           "\nTotal Amount : "+totalAmount;
    };

    // String [] transactions; 
    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
