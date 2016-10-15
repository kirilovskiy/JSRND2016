package logic;

import jdbcWork.DocumentDaoImpl;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

public class Document {
    private long id;
    private Account accDT;
    private Account accCT;
    private BigDecimal summa;
    private String purpose;
    private Date docDate;
    private DocumentDaoImpl documentDaoImpl;

    public Document() {
    }

    public void setDocumentDaoImpl(DocumentDaoImpl documentDaoImpl) {
        this.documentDaoImpl = documentDaoImpl;
    }

    public void setData(Account accDT, Account accCT, BigDecimal summa, String purpose, Date docDate) {
        this.accDT = accDT;
        this.accCT = accCT;
        this.summa = summa;
        this.purpose = purpose;
        this.docDate = new Date(docDate.getTime());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccDT() {
        return accDT;
    }

    public Account getAccCT() {
        return accCT;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public String getPurpose() {
        return purpose;
    }

    public Date getDocDate() {
        return new Date(docDate.getTime());
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", accDT=" + accDT +
                ", accCT=" + accCT +
                ", summa=" + summa +
                ", purpose='" + purpose + '\'' +
                ", docDate=" + docDate +
                '}';
    }

    @Transactional
    public void moneyTransfer(){
        if ((accDT != null) || (accCT != null) || (accDT.getSaldo().compareTo(summa) != -1)){
            accCT.setSaldo(accCT.getSaldo().add(summa));
            accDT.setSaldo(accDT.getSaldo().add(summa.negate()));
        }
    }

    @Transactional
    public void saveAccounts(){
        getAccDT().save();
        getAccCT().save();
    }

}
