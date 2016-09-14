package home.eighteenth.command;

import java.util.ArrayList;
import java.util.List;

public class InvocerCommands {
	private Document document = new Document();
	private List<Command> commands = new ArrayList<>();
	private int cntLevel = 0;
	
	public void exec(String command, String tmpStr){
		Command c = new StringCommand(document, command, tmpStr);
		c.Execute();
		commands.add(c);
		cntLevel++;
	}
	
	public void redo(int cnt){
		for(int i = 0; i < cnt; i++){
			if (cntLevel < commands.size() - 1) {
				Command command = commands.get(cntLevel++);
				command.Execute();
			}
		}
	}
	
	public void undo(int cnt){
		for(int i = 0; i < cnt; i++){
			if (cntLevel > 0) {
				Command command = commands.get(--cntLevel);
				command.UnExecute();
			}
		}
	}

	public void printHistory(){
		for(Command c: commands){
			c.PrintHistory();
		}
	}
}
