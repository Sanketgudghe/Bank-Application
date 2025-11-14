package Bank_management_system;

public class BankAccount {
    private int id;
    private String name;
    private String contact;
    private String address;
    private double balance;

    // Constructor
    public BankAccount(String name, String contact, String address, double balance) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.balance = balance;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getContact() { return contact; }
    public String getAddress() { return address; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
