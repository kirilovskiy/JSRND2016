package main.dao;

import main.logicHib.Account;
import main.logicHib.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long saveIntoDb(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(client);
        session.getTransaction().commit();
        session.close();
        return client.getId();
    }

    @Override
    public void deleteFromDb(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Client getClientFromDb(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            return session.get(Client.class,id);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<Client> getClientList() {
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("from Client order by id").list();
        session.close();
        return clients;
    }
}
