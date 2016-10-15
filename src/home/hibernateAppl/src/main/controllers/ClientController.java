package main.controllers;

import main.dao.ClientDao;
import main.logicHib.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.dao.ClientDao;
import main.logicHib.Client;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ClientController {
    public ClientController() {
    }
    ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @RequestMapping("/home/clients")
    public String getClients(){
        List<Client> clientList = clientDao.getClientList();

        return "/home/clients";
    }
}
