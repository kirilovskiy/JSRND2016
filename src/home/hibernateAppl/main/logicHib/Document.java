package main.logicHib;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "accDT", referencedColumnName = "ID")
    private Account accDT;

    @ManyToOne
    @JoinColumn(name = "accCT ", referencedColumnName = "ID")
    private Account accCT;

    @Column(name = "summa")
    private BigDecimal summa;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "docDate")
    @Temporal(value = TemporalType.DATE)
    private Date docDate;

    public Document() {}

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
            accCT.setSaldo(accCT.getSaldo().add(summa.negate()));
            accDT.setSaldo(accDT.getSaldo().add(summa));
        }
    }
}
