package logic;

import jdbcWork.ClientDaoImpl;

public class Client {
    private long id;
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
