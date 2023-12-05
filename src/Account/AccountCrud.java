package Account;

import currency.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountCrud implements AccountOperation{
    Connection connection;

    public AccountCrud(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> GetByNumberAccount(int account_number) {
        List<Account> accounts = new ArrayList<>();
        String sql = "select * from account where account_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,account_number);
            ResultSet resultSet = statement.executeQuery();
            accounts.add(new Account(
                    resultSet.getInt("account_id"),
                    resultSet.getInt("account_number"),
                    resultSet.getInt("currency_id"),
                    resultSet.getFloat("balance"),
                    resultSet.getDate("date")           ));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }
    @Override
    public List<Account> insertAccount(Account account) {
        int length = GetByNumberAccount(account.getAccount_number()).size();
        if (length > 0){
            String sql = "insert into account values (account_number , currency_id , balance , date)" +
                    "values (?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,account.getAccount_number());
                statement.setInt(2,account.getCurrency_id());
                statement.setFloat(3,account.getBalance());
                statement.setDate(4,account.getDate());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public List<Account> GetAccount() {
        List<Account> accounts = new ArrayList<>();
        String sql = "select * from account";

        try (PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet resultSet = statement.executeQuery();
            accounts.add(new Account(
                    resultSet.getInt("account_id"),
                    resultSet.getInt("account_number"),
                    resultSet.getInt("currency_id"),
                    resultSet.getFloat("balance"),
                    resultSet.getDate("date")           ));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;

    }

    @Override
    public List<Account> updateAccount(int Account_number_receive,int Account_number_send, float balance) {
        String sql1 = "update account set balance = balance - ? WHERE account_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql1)){
            statement.setInt(2,Account_number_send);
            statement.setFloat(1,balance);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql2 = "update account set balance = balance + ? WHERE account_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql2)){
            statement.setInt(2,Account_number_receive);
            statement.setFloat(1,balance);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
