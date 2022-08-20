package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private static Long accountNumber = 0L;

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
		if(accounts.containsKey(accountNumber)){
			return accounts.get(accountNumber);
		}
        return null;
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function

		this.accountNumber++;
		accounts.put(this.accountNumber, new CommercialAccount(company, accountNumber, pin, startingDeposit));
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		this.accountNumber++;
		accounts.put(this.accountNumber, new ConsumerAccount(person, accountNumber, pin, startingDeposit));
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function

		if(accounts.containsKey(accountNumber)){

			return accounts.get(accountNumber).validatePin(pin);
		}
		return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account = accounts.get(accountNumber);
		account.creditAccount(amount);
		accounts.put(accountNumber, account);

	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account account = accounts.get(accountNumber);
		if (account.getBalance() >= amount) {
			account.debitAccount(amount);
			accounts.put(accountNumber, account);
			return true;
		}else {
			return account.getBalance() >= amount;
		}
	}
}
