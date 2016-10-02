package main.jdbcWork;

import main.logic.Account;
import main.logic.Document;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DocumentDaoImpl implements DocumentDao {
    private DataSource DS;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.DS = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(long id, long accDTId, long accCTId, BigDecimal summa, String purpose, Date docDate) {
        String sql = "insert into documents (id, accDT , accCT, summa , purpose, docDate) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, accDTId, accCTId, summa, purpose, docDate);
        System.out.println("create record in documents with id = " + id );
    }

    @Override
    public Document getDocument(long id) {
        String sql = "select * from documents where id = ?";
        Document document = jdbcTemplate.queryForObject(sql, new Object[]{id}, new DocumentMapper());
        return document;
    }

    @Override
    public List<Document> listDocuments() {
        String sql = "select * from documents";
        List<Document> listDocuments = jdbcTemplate.query(sql, new DocumentMapper());
        return listDocuments;
    }

    @Override
    public List<Document> listDocuments(Account account) {
        String sql = "select * from documents where accDT = ? or accCT = ?";
        List<Document> listDocuments = jdbcTemplate.query(sql,
                                                      new Object[]{account.getId(), account.getId()},
                                                      new DocumentMapper());
        return listDocuments;
    }

    @Override
    public void del(long id) {
        String sql = "delete from documents where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("delete record from documents");
    }

    @Override
    public void upd(long id, long accDTId, long accCTId, BigDecimal summa, String purpose, Date docDate) {
        String sql = "update documents set accDT = ?, accCT = ?, summa = ?, purpose = ?, docDate = ?  where id = ?";
        jdbcTemplate.update(sql, accDTId, accCTId, summa, purpose, docDate , id);
        jdbcTemplate.update(sql, accDTId, accCTId, summa, purpose, docDate , id);
        System.out.println("update record documents with id = " + id);
    }
}
