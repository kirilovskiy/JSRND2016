package dao;

import logicHib.Account;
import logicHib.Client;
import logicHib.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DocumentDaoImpl implements DocumentDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveIntoDb(Document document) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(document);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Document> getDocumentList() {
        Session session = sessionFactory.openSession();
        List<Document> documents = session.createQuery("from Document order by id").list();
        session.close();
        return documents;
    }

    @Override
    public Document getDocumentFromDb(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            return session.get(Document.class,id);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}
