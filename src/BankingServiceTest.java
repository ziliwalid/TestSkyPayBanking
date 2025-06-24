import entities.Account;

public class BankingServiceTest {

    public static void main(String[] args) {
        System.out.println("=== Banking Service Technical Test ===\n");

        // Test the exact acceptance criteria from the PDF
        testAcceptanceCriteria();

        // Test error handling
        testErrorHandling();
    }

    public static void testAcceptanceCriteria() {
        System.out.println("Testing Acceptance Criteria:");
        System.out.println("Given a client makes a deposit of 1000 on 10-01-2012");
        System.out.println("And a deposit of 2000 on 13-01-2012");
        System.out.println("And a withdrawal of 500 on 14-01-2012");
        System.out.println("When they print their bank statement");
        System.out.println("Then they would see:\n");

        Account account = new Account();

        // Execute the test scenario
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        // Print the statement
        account.printStatement();

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    public static void testErrorHandling() {
        System.out.println("Testing Error Handling:\n");

        Account account = new Account();

        // Test negative deposit
        try {
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Negative deposit rejected: " + e.getMessage());
        }

        // Test zero deposit
        try {
            account.deposit(0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Zero deposit rejected: " + e.getMessage());
        }

        // Test withdrawal with insufficient funds
        try {
            account.withdraw(100);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Insufficient funds withdrawal rejected: " + e.getMessage());
        }

        // Test negative withdrawal
        try {
            account.withdraw(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Negative withdrawal rejected: " + e.getMessage());
        }

        System.out.println("\nValid operations:");
        account.deposit(500);
        System.out.println("Deposited 500");

        account.withdraw(200);
        System.out.println("Withdrew 200");

        System.out.println("\nCurrent statement:");
        account.printStatement();
    }
}