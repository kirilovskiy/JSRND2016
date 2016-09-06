package com.sbt.lesson17;

public class Main {
    public static void main(String[] args) {
        Document infodoc = new Document(new InfoDocExecBehavior());
        DocumentExecutor de = new DocumentExecutor();

        Account accA = new Account();
        accA.setSaldo(100L);

        Account accB = new Account();
        accB.setSaldo(100L);


        infodoc.setAccA(accA);
        infodoc.setAccB(accB);

        infodoc.setSumma(10L);
        de.exec(infodoc);
    }
}
