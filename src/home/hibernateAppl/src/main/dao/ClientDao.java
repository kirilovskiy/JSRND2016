package main.dao;

import main.logicHib.Client;
import main.logicHib.Client;

import java.util.List;

public interface ClientDao {
    long saveIntoDb(Client client);
    void deleteFromDb(Client client);
    Client getClientFromDb(long id);
    List<Client> getClientList();
}
