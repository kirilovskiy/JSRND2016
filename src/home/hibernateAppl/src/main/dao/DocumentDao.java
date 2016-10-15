package main.dao;

import main.logicHib.Document;

import java.util.List;

public interface DocumentDao {
    void saveIntoDb(Document document);
    List<Document> getDocumentList();
}
