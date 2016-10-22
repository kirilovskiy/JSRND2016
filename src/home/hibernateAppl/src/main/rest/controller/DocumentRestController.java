package rest.controller;

import dao.DocumentDao;
import logicHib.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentRestController {
    DocumentDao documentDao;

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    @GetMapping(value = "/documents")
    public ResponseEntity<List<Document>> getDocuments(){
        List<Document> documents = documentDao.getDocumentList();
        if (documents.isEmpty()){
            return new ResponseEntity<List<Document>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Document>>(documents,HttpStatus.OK);
    }

    @GetMapping(value = "/documents/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable String id){
        Document document = documentDao.getDocumentFromDb(Long.parseLong(id));
        if (document == null){
            return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Document>(document,HttpStatus.OK);
    }
}
