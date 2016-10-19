package home.twelfth.src.main.java.first;

class MyRunnable implements Runnable{
    private String mes;

    public MyRunnable(String mes) {
        this.mes = mes;
    }
    @Override
    public void run() {
        System.out.println("Выполнял поток " + Thread.currentThread().getName()+"; Сообщение - '" + mes +"\'");
    }
}
public class Main{
    public static void main(String[] args) throws Exception {
/*
        System.out.println("start main program");
        WorkQueue workQueue = new WorkQueue(Runtime.getRuntime().availableProcessors());
        for(int i = 0; i < 50 ; i++) {
            final int finalI = i;
            Task<String> task = new Task(() -> {
                return "first.Task with number '" + finalI + "\' ";
            });
            workQueue.execute(new MyRunnable(task.get()));
        }

        while(!workQueue.isEndFlag()){workQueue.EndFlag();}

        System.out.println("end main program");
        System.exit(1);
*/

    }


}