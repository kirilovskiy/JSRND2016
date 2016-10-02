package main;

import main.jdbcWork.AccountDao;
import main.jdbcWork.ClientDao;
import main.jdbcWork.DocumentDao;
import main.logic.Account;
import main.logic.Client;
import main.logic.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ClientDao clientJDBC = (ClientDao) utilContext.context.getBean("ClientDaoImpl");
        AccountDao accountJDBC = (AccountDao) utilContext.context.getBean("AccountDaoImpl");
        DocumentDao documentJDBC = (DocumentDao) utilContext.context.getBean("DocumentDaoImpl");
        /*Account account = (Account) utilContext.context.getBean("account");
        Account account1 = (Account) utilContext.context.getBean("account");
        Document document = (Document) utilContext.context.getBean("document");
        clientJDBC.create(1, "John Dyson");
        clientJDBC.create(2, "LeBron James");

        account.setData(3,"0000000000000003", clientJDBC.getClient(1), BigDecimal.valueOf(3000.00));
        System.out.println(account.toString());
        account1.setData(2,"0000000000000002", clientJDBC.getClient(2), BigDecimal.valueOf(2000.00));
        System.out.println(account1.toString());

        accountJDBC.create(account.getId(), account.getAccNumber(), account.getClient().getId(),account.getSaldo());
        accountJDBC.create(account1.getId(), account1.getAccNumber(), account1.getClient().getId(),account1.getSaldo());


        document.setData(account, account1, BigDecimal.valueOf(500.00), "very need", new Date());
        documentJDBC.create(document.getId(), account.getId(), account1.getId(),
                            document.getSumma(), document.getPurpose(), document.getDocDate());*/

        /*
        //Список счетов по клиенту
        List<Account> accounts = accountJDBC.listAccounts(1);
        System.out.println("accounts of client: " + clientJDBC.getClient(1).toString());
        for(Account account : accounts){
            System.out.println("Account number: " + account.getAccNumber());
            System.out.println("Start saldo: " + account.getSaldo());
        }*/


        Account account = accountJDBC.getAccount(2);
        List<Document> documents = documentJDBC.listDocuments(account);
        BigDecimal summa = BigDecimal.valueOf(0);
        System.out.println("operations:");
        for(Document document : documents){
            if (document.getAccDT().getId() == account.getId()){
                System.out.println(document.getAccCT().getClient().getName()+ "  " +
                                   document.getAccCT().getAccNumber()+ "   " +
                                   "credit   " +
                                   document.getSumma());
                summa = summa.subtract(document.getSumma());
            }
            else {
                System.out.println(document.getAccDT().getClient().getName()+ "  " +
                        document.getAccDT().getAccNumber()+ "   " +
                        "debet   " +
                        document.getSumma());
                summa = summa.add(document.getSumma());
            }
            document.moneyTransfer();
            System.out.println(document.getAccDT().getClient().getName()+" "+document.getAccDT().getSaldo());
            System.out.println(document.getAccCT().getClient().getName()+" "+document.getAccCT().getSaldo());
        }

        System.out.println("balance document processing: " + summa);
    }
}
