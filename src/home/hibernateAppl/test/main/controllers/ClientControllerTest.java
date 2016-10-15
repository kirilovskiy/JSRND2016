package main.controllers;

import main.controllers.ClientController;
import main.dao.ClientDao;
import main.dao.ClientDaoImpl;
import org.junit.*;

import static org.mockito.Mockito.mock;

public class ClientControllerTest {

    @Test
    public void showClients(){
        ClientDao clientDao = mock(ClientDaoImpl.class);
        ClientController clientController = new ClientController(clientDao);
        String namePage = clientController.getClients();
        Assert.assertEquals("/home/clients", namePage);
    }
}
