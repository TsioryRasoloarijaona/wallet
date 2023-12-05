package currency;

public class Currency {
    private int currency_id;
    private String currency_name;

    public Currency(int currency_id, String currency_name) {
        this.currency_id = currency_id;
        this.currency_name = currency_name;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currency_id=" + currency_id +
                ", currency_name='" + currency_name + '\'' +
                '}';
    }
}
