package Account;

import java.util.Date;

public class Account {
    private int account_id;
    private int account_number;
    private int currency_id;
    private float balance;

    private Date date;

    public Account(int account_id, int account_number, int currency_id, float balance, Date date) {
        this.account_id = account_id;
        this.account_number = account_number;
        this.currency_id = currency_id;
        this.balance = balance;
        this.date = date;
    }

    public Account(int account_number, int currency_id, float balance, Date date) {
        this.account_number = account_number;
        this.currency_id = currency_id;
        this.balance = balance;
        this.date = date;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account_number=" + account_number +
                ", currency_id=" + currency_id +
                ", balance=" + balance +
                ", date=" + date +
                '}';
    }
}
