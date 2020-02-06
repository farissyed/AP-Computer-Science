public class BankAccount {
	private double balance;

	public BankAccount() {
		balance = 0;
	}

	public BankAccount(double acctBalance) {
		balance = acctBalance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}

public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount() {
		/* implementation not shown */ }

	public SavingsAccount(double acctBalance, double rate) {
		/* implementation not shown */ }

	public void addInterest() // Add interest to balance
	{
		/* implementation not shown */ }
}

public class CheckingAccount extends BankAccount {
	private static final double FEE = 2.0;
	private static final double MIN_BALANCE = 50.0;

	public CheckingAccount(double acctBalance) {
		/* implementation not shown */ }

	/**
	 * FEE of $2 deducted if withdrawal leaves balance less than MIN_BALANCE. Allows
	 * for negative balance.
	 */
	public void withdraw(double amount) {
		/* implementation not shown */ }
}