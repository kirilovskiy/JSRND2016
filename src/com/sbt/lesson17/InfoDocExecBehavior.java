package com.sbt.lesson17;

public class InfoDocExecBehavior  implements  ExecBehavior {
    @Override
    public void exec(Document document) {
        System.out.println("this is infodoc");
    }
}
