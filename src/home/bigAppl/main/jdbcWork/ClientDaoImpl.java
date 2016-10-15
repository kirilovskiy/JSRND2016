package jdbcWork;

import logic.Client;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private DataSource DS;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.DS = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(long id, String name) {
        String sql = "insert into clients (id , name) values (?,?)";
        jdbcTemplate.update(sql, id, name);
        System.out.println("create record in clients with id = " + id + " Name = " + name);
    }

    @Override
    public Client getClient(long id) {
        String sql = "select * from clients where id = ?";
        Client client = jdbcTemplate.queryForObject(sql, new Object[]{id}, new ClientMapper());
        return client;
    }

    @Override
    public List<Client> listClients() {
        String sql = "select * from clients";
        List<Client> clients = jdbcTemplate.query(sql, new ClientMapper());
        return clients;
    }

    @Override
    public void del(long id) {
        String sql = "delete from clients where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("delete record from clients");
    }

    @Override
    public void upd(long id, String name) {
        String sql = "update clients set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);
        System.out.println("update record clients with id = " + id);
    }

    public void merge(long id, String name) {
        String SQL = "MERGE INTO clients KEY(ID) VALUES(?, ?)";
        jdbcTemplate.update(SQL, id, name);
        System.out.println("----merge clients----");
    }

}
