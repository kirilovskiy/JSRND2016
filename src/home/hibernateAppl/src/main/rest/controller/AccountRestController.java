package rest.controller;

import dao.AccountDao;
import dao.ClientDao;
import logicHib.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity<List<Account>> getAccounts(){
        List<Account> accounts = accountDao.getAccountList();
        if (accounts.isEmpty()){
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }

    @GetMapping(value = "/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id){
        Account account = accountDao.getAccountFromDb(Long.parseLong(id));
        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
}
