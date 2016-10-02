package main.jdbcWork;

import main.logic.Account;
import main.logic.Client;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {
    void setDataSource(DataSource ds);
    void create(long id, String accNumber, long clientId, BigDecimal saldo);
    Account getAccount(long id);
    List<Account> listAccounts();
    void del(long id);
    void upd(long id, String accNumber, long clientId, BigDecimal saldo);
}
