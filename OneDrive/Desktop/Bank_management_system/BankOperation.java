package Bank_management_system;

public interface BankOperation 
{
	    void register(BankAccount account);
	    void deposit(int id, double amount);
	    void withdraw(int id, double amount);
	    void checkBalance(int id);
	


}
