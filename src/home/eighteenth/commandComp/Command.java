package home.eighteenth.commandComp;

public abstract class Command {
	Computer computer;
	
	public Command(Computer computer) {
		this.computer = computer;
	};
	
	abstract void execute();
}
