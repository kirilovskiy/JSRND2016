package main.dao;

import main.logicHib.Account;
import main.logicHib.Client;
import java.math.BigDecimal;

import main.utilContext;
import org.junit.*;


public class AccountDaoImplTest {
    @Test
    public void testAddDelAccount() throws Exception{
        final AccountDaoImpl accountDao = utilContext.getApplicationContext().getBean(AccountDaoImpl.class);
        final ClientDaoImpl clientDao = utilContext.getApplicationContext().getBean(ClientDaoImpl.class);

        final Account account = new Account();
        final Client client = new Client("QWEERTY");
        clientDao.saveIntoDb(client);
        account.setData("0000345" , client , BigDecimal.valueOf(100.00));

        final long id = accountDao.saveIntoDb(account);
        final Account account1 = accountDao.getAccountFromDb(id);

        Assert.assertEquals(id, account1.getId());
        accountDao.deleteFromDb(account1);
        clientDao.deleteFromDb(client);
        Assert.assertNull(accountDao.getAccountFromDb(id));
        Assert.assertNull(clientDao.getClientFromDb(client.getId()));
    }
}
