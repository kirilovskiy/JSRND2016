package main.dao;

import main.logicHib.Account;
import main.logicHib.Client;

import java.util.List;

public interface AccountDao {
    long saveIntoDb(Account account);
    void deleteFromDb(Account account);
    Account getAccountFromDb(long id);
    List<Account> getAccountList();
}
