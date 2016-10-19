package rest.controller;

import dao.ClientDao;
import logicHib.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestController {
    ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping(value = "/client")
    public ResponseEntity<List<Client>> listAllClients() {
        List<Client> clients = clientDao.getClientList();
        if (clients.isEmpty()) {
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
}
