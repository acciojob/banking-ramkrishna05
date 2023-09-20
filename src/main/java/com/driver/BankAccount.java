package com.driver;

public class BankAccount {
    protected String name;
    protected double balance; // Changed access modifier to protected
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public BankAccount() {
        this.name = "";
        this.balance = 0.0;
        this.minBalance = 0.0;
    }

    public void deposit(double amount) {
        // Deposit logic
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (this.balance - amount < this.minBalance) {
            throw new Exception("Insufficient Balance");
        }
        // Withdraw logic
        this.balance -= amount;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        // Generate account number having given number of 'digits'
        // such that the sum of digits is equal to 'sum'
        if (digits < 1 || digits > 9 || sum < 0 || sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");
        }

        StringBuilder accountNumber = new StringBuilder();
        int remainingSum = sum;

        for (int i = 0; i < digits; i++) {
            int maxDigit = Math.min(remainingSum, 9);
            int digit = (int) (Math.random() * (maxDigit + 1));
            accountNumber.append(digit);
            remainingSum -= digit;
        }

        return accountNumber.toString();
    }
}
