package main.jdbcWork;

import main.logic.Client;

import javax.sql.DataSource;
import java.util.List;

public interface ClientDao {
    void setDataSource(DataSource ds);
    void create(long id, String name);
    Client getClient(long id);
    List<Client> listClients();
    void del(long id);
    void upd(long id);
}
