package main.jdbcWork;

import main.logic.Account;
import main.logic.Client;
import main.logic.Document;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface DocumentDao {
    void setDataSource(DataSource ds);
    void create(long id, long accDTId, long accCTId, BigDecimal summa, String purpose, Date docDate);
    Document getDocument(long id);
    List<Document> listDocuments();
    List<Document> listDocuments(Account account);
    void del(long id);
    void upd(long id, long accDTId, long accCTId, BigDecimal summa, String purpose, Date docDate);
}
