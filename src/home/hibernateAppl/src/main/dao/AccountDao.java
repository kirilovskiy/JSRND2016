package dao;

import logicHib.*;

import java.util.List;

public interface AccountDao {
    long saveIntoDb(Account account);
    void deleteFromDb(Account account);
    Account getAccountFromDb(long id);
    List<Account> getAccountList();
}
