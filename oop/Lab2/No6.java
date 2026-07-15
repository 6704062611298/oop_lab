package Lab2;
import java.util.Date;

class Account {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    public double getBalance() {
        return balance;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 100) / 12;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

public class No6 {
    public static void main(String[] args) {

        Account acc = new Account(1122, 20000);

        acc.setAnnualInterestRate(4.5);

        acc.withdraw(2500);

        acc.deposit(3000);

        System.out.println("Balance = " + acc.getBalance());
        System.out.println("Monthly Interest = " + acc.getMonthlyInterest());
    }
}