package currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyCrud implements CurrencyOperation{
    Connection connection;

    public CurrencyCrud(Connection connection) {
        this.connection = connection;
    }




    @Override
    public List<Currency> GetCurrency() {
        List<Currency> currency = new ArrayList<>();
        String sql = "select * from currency";
        ResultSet resultSet;
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                currency.add(new Currency(
                        resultSet.getInt("currency_id"),
                        resultSet.getString("currency_name")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currency;
    }

    @Override
    public List<Currency> updateCurrency(int currency_id , String currency_name) {
        String sql = "update currency set currency_name = ? where currency_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(2,currency_id);
            statement.setString(1,currency_name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Currency> GetByNameCurrency(String currency_name) {
        List<Currency> currency = new ArrayList<>();
        String sql = "select * from where currency_name = ?";
        ResultSet resultSet;
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            resultSet = statement.executeQuery();
            statement.setString(1,currency_name);
            while (resultSet.next()){
                currency.add(new Currency(
                        resultSet.getInt("currency_id"),
                        resultSet.getString("currency_name")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currency;
    }

    public List<Currency> insertCurrency(Currency currency) {
        List<Currency> currencies = new ArrayList<>();
        int length = GetByNameCurrency(currency.getCurrency_name()).size();
        if (length > 0){
            String sql = "insert into currency (currency_name) values (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,currency.getCurrency_name());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return currencies;
    }

}
