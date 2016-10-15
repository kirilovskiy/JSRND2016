package jdbcWork;

import logic.Account;
import logic.Client;
import logic.utilContext;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = (Account) utilContext.context.getBean("account");
        ClientDao clientDaoImpl = (ClientDao) utilContext.context.getBean("ClientDaoImpl");
        long clientId = rs.getLong("clientId");
        Client client = clientDaoImpl.getClient(clientId);

        account.setId(rs.getLong("id"));
        account.setAccNumber(rs.getString("accNumber"));
        account.setClient(client);
        account.setSaldo(rs.getBigDecimal("saldo"));

        return account;
    }
}
