class NegativeAmountException extends Exception {
  public NegativeAmountException(String message) {
    super(message);
  }
}

class InsufficientFundsException extends Exception {
  public InsufficientFundsException(String message) {
    super(message);
  }
}

class LowBalanceException extends Exception {
  public LowBalanceException(String message) {
    super(message);
  }
}

class BankAccount {
  private String accountNumber;
  private double balance;
  private final double MINIMUM_BALANCE = 1000.0;

  public BankAccount(String accountNumber, double initialBalance) throws LowBalanceException, NegativeAmountException {
    if (initialBalance < 0) {
      throw new NegativeAmountException("Initial balance cannot be negative.");
    }
    if (initialBalance < MINIMUM_BALANCE) {
      throw new LowBalanceException("Initial deposit must maintain the minimum balance of ₹" + MINIMUM_BALANCE);
    }
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
  }

  public void deposit(double amount) throws NegativeAmountException {
    if (amount <= 0) {
      throw new NegativeAmountException("Deposit amount must be greater than zero.");
    }
    balance += amount;
    System.out.println("Successfully deposited ₹" + amount);
  }

  public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException, LowBalanceException {
    if (amount <= 0) {
      throw new NegativeAmountException("Withdrawal amount must be greater than zero.");
    }
    if (amount > balance) {
      throw new InsufficientFundsException("Insifficient funds. Available balance: ₹" + balance);
    }
    if ((balance - amount) < MINIMUM_BALANCE) {
      throw new LowBalanceException("Transaction denied. Balance cannot drop below the minimum required ₹" + MINIMUM_BALANCE);
    }
    balance -= amount;
    System.out.println("Successfully withdraw ₹" + amount);
  }

  public void checkBalance() {
    System.out.println("AccountNumber: " + accountNumber + " | Current Balance: ₹" + balance);
  }
}

class practical27 {
  public static void main(String[] args) {
    try {
      System.out.println("--- Creating Account ---");
      BankAccount account = new BankAccount("SBI-12345", 5000.0);
      account.checkBalance();

      System.out.println("--- Testing Valid Deposit ---");
      account.deposit(1500.0);
      account.checkBalance();

      System.out.println("--- Testing Negative Deposit ---");
      account.deposit(-500.0);
    }
    catch (Exception e) {
      System.out.println("Exception caught: " + e.getMessage());
    }

    try {
      BankAccount account = new BankAccount("SBI-12345", 2000.0);

      System.out.println("--- Testing Low Balance Rule ---");
      account.withdraw(1500.0);
    }
    catch (Exception e){
      System.out.println("Exception caught: " + e.getMessage());
    }

    try {
      BankAccount account = new BankAccount("SBI-12345", 1500.0);

      System.out.println("--- Testing Insufficient Funds ---");
      account.withdraw(3000.0);
    }
    catch (Exception e){
      System.out.println("Exceotion caught: " + e.getMessage());
    }
  }
}
