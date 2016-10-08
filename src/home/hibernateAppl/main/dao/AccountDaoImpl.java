package main.dao;

import main.logicHib.Account;
import main.logicHib.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AccountDaoImpl implements AccountDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long saveIntoDb(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(account);
        session.getTransaction().commit();
        session.close();
        return account.getId();
    }

    @Override
    public void deleteFromDb(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Account getAccountFromDb(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            return session.get(Account.class,id);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<Account> getAccountList() {
        Session session = sessionFactory.openSession();
        List<Account> accounts = session.createQuery("from Account order by id").list();
        session.close();
        return accounts;
    }
}
