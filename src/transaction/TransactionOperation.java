package transaction;

import java.util.List;

public interface TransactionOperation {
    Transaction insertTransaction(Transaction transaction);

    List<Transaction> getTransaction();

    List<Transaction> updaateTransaction();
}

