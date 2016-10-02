package main.jdbcWork;

import main.logic.Account;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private DataSource DS;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.DS = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(long id, String accNumber, long clientId, BigDecimal saldo) {
        String sql = "insert into accounts (id, accNumber , clientId , saldo) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, accNumber, clientId, saldo);
        System.out.println("create record in clients with id = " + id + " accNumber = " + accNumber);
    }

    @Override
    public Account getAccount(long id) {
        String sql = "select * from accounts where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new Object[]{id}, new AccountMapper());
        return account;
    }

    @Override
    public List<Account> listAccounts() {
        String sql = "select * from accounts";
        List<Account> listAccounts = jdbcTemplate.query(sql, new AccountMapper());
        return listAccounts;
    }

    @Override
    public List<Account> listAccounts(long clientId) {
        String sql = "select * from accounts where clientId = ?";
        List<Account> listAccounts = jdbcTemplate.query(sql, new Object[]{clientId}, new AccountMapper());
        return listAccounts;
    }

    @Override
    public void del(long id) {
        String sql = "delete from accounts where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("delete record from accounts");
    }

    @Override
    public void upd(long id, String accNumber, long clientId, BigDecimal saldo) {
        String sql = "update accounts set accNumber = ?, clientId = ?, saldo =?  where id = ?";
        jdbcTemplate.update(sql, accNumber, clientId, saldo , id);
        System.out.println("update record clients with id = " + id);
    }
}
