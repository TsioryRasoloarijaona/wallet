package transaction;

import Account.AccountCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionCrud implements TransactionOperation{
    Connection connection;
    AccountCrud accountCrud;

    public TransactionCrud(AccountCrud accountCrud) {
        this.accountCrud = accountCrud;
    }

    public TransactionCrud(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Transaction insertTransaction(Transaction transaction) {
        String sql = "insert into transaction values (provider , receiver , value) values (?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,transaction.getProvider());
            statement.setInt(2,transaction.getReceiver());
            statement.setFloat(1,transaction.getValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        accountCrud.updateAccount(transaction.getReceiver() , transaction.getProvider() , transaction.getValue());
        return transaction;
    }

    @Override
    public List<Transaction> getTransaction() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "select * from transaction ";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet result = statement.executeQuery();
            while (result.next()){
                transactions.add(new Transaction(
                        result.getInt("transaction_id"),
                        result.getInt("provider"),
                        result.getInt("receiver"),
                        result.getFloat("value"),
                        result.getDate("Date")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Transaction> updaateTransaction() {
        return null;
    }
}
