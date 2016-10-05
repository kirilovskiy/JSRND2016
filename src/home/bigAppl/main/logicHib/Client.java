package main.logicHib;

import main.jdbcWork.ClientDaoImpl;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CLIENTS")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", length = 2000)
    private String name;

    public ClientDaoImpl clientDaoImpl;

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setClientDaoImpl(ClientDaoImpl clientDaoImpl) {
        this.clientDaoImpl = clientDaoImpl;
    }

    public void save(){
        clientDaoImpl.merge(id,name);
    }
}
