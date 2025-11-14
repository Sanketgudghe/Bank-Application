package Bank_management_system;
import java.sql.*;

public class BankService implements BankOperation {

    @Override
    public void register(BankAccount account) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO customers (name, contact, address, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, account.getName());
            ps.setString(2, account.getContact());
            ps.setString(3, account.getAddress());
            ps.setDouble(4, account.getBalance());
            ps.executeUpdate();
            System.out.println("✅ Registration successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(int id, double amount) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "UPDATE customer SET balance = balance + ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, amount);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Amount"+amount+" deposited successfully!");
            else System.out.println("Account not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(int id, double amount) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String checkQuery = "SELECT balance FROM customer WHERE id = ?";
            PreparedStatement ps1 = con.prepareStatement(checkQuery);
            ps1.setInt(1, id);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                if (balance >= amount) {
                		
                		double newBalance=balance-amount;
                    String updateQuery = "UPDATE customer SET balance = balance - ? WHERE id = ?";
                   
                    PreparedStatement ps2 = con.prepareStatement(updateQuery);
                    ps2.setDouble(1, amount);
                    ps2.setInt(2, id);
                    ps2.executeUpdate();
                    
                   
                    System.out.println(amount+" Rs Withdrawal successful!");
                    System.out.println("Available Balance is "+newBalance);
                    
                } else {
                    System.out.println("Insufficient balance!");
                }
            } else {
                System.out.println("Account not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkBalance(int id) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT balance FROM customer WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Current Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
