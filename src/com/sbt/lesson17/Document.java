package com.sbt.lesson17;

public class Document {

    private Client clientA;
    private Account accA;

    private Client clientB;
    private Account accB;

    private String user;

    private Long summa;

    public ExecBehavior getExecBehavior() {
        return execBehavior;
    }

    public void setExecBehavior(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    private ExecBehavior execBehavior;

    public Client getClientA() {
        return clientA;
    }

    public void setClientA(Client clientA) {
        this.clientA = clientA;
    }

    public Account getAccA() {
        return accA;
    }

    public void setAccA(Account accA) {
        this.accA = accA;
    }

    public Client getClientB() {
        return clientB;
    }

    public void setClientB(Client clientB) {
        this.clientB = clientB;
    }

    public Account getAccB() {
        return accB;
    }

    public void setAccB(Account accB) {
        this.accB = accB;
    }

    public Long getSumma() {
        return summa;
    }

    public void setSumma(Long summa) {
        this.summa = summa;
    }

    public Document(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    public void print(){
        System.out.println("summa:" + getSumma());
    }

    public void getUserInfo(){
        System.out.println("Document User:" + user);
    }

    public void saveToDB(){
        System.out.println("Save document to DB");
    }
}

