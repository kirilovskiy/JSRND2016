package main.jdbcWork;

import main.logic.Account;
import main.logic.Document;
import main.utilContext;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentMapper implements RowMapper<Document> {
    @Override
    public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
        Document document = (Document) utilContext.context.getBean("document");
        AccountDao accountDao = (AccountDao) utilContext.context.getBean("AccountDaoImpl");
        Account accountDT = accountDao.getAccount(rs.getLong("accDT"));
        Account accountCT = accountDao.getAccount(rs.getLong("accCT"));
        document.setId(rs.getLong("id"));
        document.setData(accountDT,accountCT,
                         rs.getBigDecimal("summa"),rs.getString("purpose"),rs.getDate("docDate"));
        return document;
    }
}
