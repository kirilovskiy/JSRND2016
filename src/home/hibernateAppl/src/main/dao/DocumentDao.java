package dao;

import logicHib.Document;

import java.util.List;

public interface DocumentDao {
    void saveIntoDb(Document document);
    List<Document> getDocumentList();
    Document getDocumentFromDb(long id);
}
