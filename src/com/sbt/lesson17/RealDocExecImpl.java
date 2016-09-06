package com.sbt.lesson17;

public class RealDocExecImpl implements ExecBehavior {

    @Override
    public void exec(Document document) {
        document.getAccA().setSaldo(document.getAccB().getSaldo() - document.getSumma());
        document.getAccB().setSaldo(document.getAccB().getSaldo() + document.getSumma());
        System.out.println("from Account A to Account B:" + document.getSumma());
    }
}
