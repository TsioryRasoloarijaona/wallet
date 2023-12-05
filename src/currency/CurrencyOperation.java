package currency;

import java.util.List;

public interface CurrencyOperation {
    List<Currency> insertCurrency(Currency currency);
    List<Currency> GetCurrency();
    List<Currency> updateCurrency(int currency_id , String currency_name);
    List<Currency> GetByNameCurrency(String currency_name);

}
