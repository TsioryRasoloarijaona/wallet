package transaction;

import java.util.Date;

public class Transaction {
    private int transaction_id ;
    private int provider;
    private int receiver ;
    private float value;
    private Date date;

    public Transaction(int transaction_id, int provider, int receiver, float value, Date date) {
        this.transaction_id = transaction_id;
        this.provider = provider;
        this.receiver = receiver;
        this.value = value;
        this.date = date;
    }

    public Transaction(int provider, int receiver, float value) {
        this.provider = provider;
        this.receiver = receiver;
        this.value = value;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "transaction_id=" + transaction_id +
                ", provider=" + provider +
                ", receiver=" + receiver +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
