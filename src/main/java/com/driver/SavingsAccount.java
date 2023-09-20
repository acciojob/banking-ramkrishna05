
package com.driver;

public class SavingsAccount extends BankAccount {
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0); // minimum balance is 0 by default
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        } else if (amount > balance) {
            throw new Exception("Insufficient Balance");
        }
        // Withdraw logic
        this.balance -= amount;
    }

    public double getSimpleInterest(int years) {
        // Calculate simple interest
        return balance * (1 + (rate * years / 100));
    }

    public double getCompoundInterest(int times, int years) {
        // Calculate compound interest
        return balance * Math.pow(1 + (rate / times), times * years);
    }
}
