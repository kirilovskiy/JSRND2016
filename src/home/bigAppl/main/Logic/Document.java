package main.logic;

import java.math.BigDecimal;
import java.util.Date;

public class Document {
    private long id;
    private Account accDT;
    private Account accCT;
    private BigDecimal summa;
    private String purpose;
    private Date docDate;

    public Document() {
    }

    public void setData(Account accDT, Account accCT, BigDecimal summa, String purpose, Date docDate) {
        this.accDT = accDT;
        this.accCT = accCT;
        this.summa = summa;
        this.purpose = purpose;
        this.docDate = docDate;
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
        return docDate;
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
}
