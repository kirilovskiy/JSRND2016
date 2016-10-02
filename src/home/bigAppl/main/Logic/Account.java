package main.logic;

import java.math.BigDecimal;

public class Account {
    private long id;
    private String accNumber;
    private Client client;
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
