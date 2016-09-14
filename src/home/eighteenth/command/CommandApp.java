package home.eighteenth.command;

public class CommandApp {
	public static void main(String[] args){
		InvocerCommands invocerCommands = new InvocerCommands();
		invocerCommands.exec("add", "1");
		invocerCommands.exec("add", "|2|");
		invocerCommands.exec("add", "|3|");
		invocerCommands.exec("add", "|4|");
		invocerCommands.undo(2);
		invocerCommands.redo(1);
		System.out.println("--------------------------------------------");
		invocerCommands.printHistory();
	}
}
