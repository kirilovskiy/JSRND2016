package home.eighteenth.command;

public class StringCommand extends Command {
	private Document document;
	private String command;
	private String tmpStr;
	
	public StringCommand(Document document,String command, String tmpStr) {
		this.document = document;
		this.command = command;
		this.tmpStr = tmpStr;
	}
	
	public String getTmpStr() {
		return tmpStr;
	}
	
	public String getCommand() {
		return command;
	}

	@Override
	void Execute() {
		document.Operation(command, tmpStr);
	}

	@Override
	void UnExecute() {
		document.Operation(undo(command), tmpStr);
	}
	
	private String undo(String command){
		switch(command){
			case "del" : return "add";
			case "add" : return "del";
			default : throw new RuntimeException("this command :["+command+"] is not supported");
		}

	}

	@Override
	void PrintHistory() {
		System.out.println(command + " ____  " + tmpStr);		
	}
}
