
import dao.*;
import logicHib.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientDao clientDao = utilContext.getApplicationContext().getBean(ClientDaoImpl.class);
        AccountDao accountDao = utilContext.getApplicationContext().getBean(AccountDaoImpl.class);
        DocumentDao documentDao = utilContext.getApplicationContext().getBean(DocumentDaoImpl.class);

        /*Client client =  utilContext.getApplicationContext().getBean(Client.class);
        Client client1 =  utilContext.getApplicationContext().getBean(Client.class);
        Account accDT =  utilContext.getApplicationContext().getBean(Account.class);
        Account accCT =  utilContext.getApplicationContext().getBean(Account.class);
        Document document = utilContext.getApplicationContext().getBean(Document.class);

        client.setName("D-Wade");
        client1.setName("Kevin Durant");

        accDT.setData("0000000000000004", client, BigDecimal.valueOf(2000.00));
        accCT.setData("0000000000000005", client1, BigDecimal.valueOf(1000.00));

        document.setData(accDT, accCT, BigDecimal.valueOf(500.00), "very need money for honey", new Date());

        clientDao.saveIntoDb(client);
        clientDao.saveIntoDb(client1);
        accountDao.saveIntoDb(accDT);
        accountDao.saveIntoDb(accCT);
        documentDao.saveIntoDb(document);
*/
        List<Account> accounts = accountDao.getAccountList();
        for(Account account : accounts){
            System.out.println(account.toString());
        }

        System.out.println("--------------------------------------------");

        List<Document> documents = documentDao.getDocumentList();
        System.out.println("operations:");
        for(Document document : documents){
            System.out.println("Client DT : " + document.getAccDT().getClient().getName() + " will receive " + document.getSumma());
            System.out.println("Client CT : " + document.getAccCT().getClient().getName()+ " will give " + document.getSumma());
            document.moneyTransfer();
            accountDao.saveIntoDb(document.getAccDT());
            accountDao.saveIntoDb(document.getAccCT());
            documentDao.saveIntoDb(document);
        }

        System.out.println("--------------------------------------------------");
        accounts = accountDao.getAccountList();
        for(Account account : accounts){
            System.out.println(account.toString());
        }
    }
}
