package main.logicHib;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "accNumber", unique = true, nullable = false, length = 2000)
    private String accNumber;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private Client client;

    @Column(name = "saldo")
    private BigDecimal saldo;

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setData(String accNumber, Client client, BigDecimal saldo){
        this.accNumber = accNumber;
        this.client = client;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accNumber='" + accNumber + '\'' +
                ", client=" + client +
                ", saldo=" + saldo +
                '}';
    }

}
