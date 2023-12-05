package Account;

import currency.Currency;

import java.util.List;

public interface AccountOperation {
    List<Account> insertAccount(Account account);
    List<Account> GetAccount();
    List<Account> updateAccount(int Account_number,int Account_number_send , float balance);
    List<Account> GetByNumberAccount(int acount_number);
}
