package main.logicHib;

import main.jdbcWork.AccountDaoImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ANNOTATIONS")
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @Column(name = "ACCNUMBER", unique = true, nullable = false, length = 2000)
    private String accNumber;

    @ManyToOne
    @JoinColumn(name = "CLIENTID", referencedColumnName = "ID")
    private Client client;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    public AccountDaoImpl accountDaoImpl;

    public void setAccountDaoImpl(AccountDaoImpl accountDaoImpl) {
        this.accountDaoImpl = accountDaoImpl;
    }

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

    public void setData(long id, String accNumber, Client client, BigDecimal saldo){
        this.id = id;
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

    public void save(){
        client.save();
        accountDaoImpl.merge(id, accNumber, client.getId(), saldo);
    }

}
