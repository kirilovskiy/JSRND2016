package home.eighteenth.commandComp;

public class StartCommand extends Command{
	
	public StartCommand(Computer computer) {
		super(computer); 
	}
	@Override
	public void execute() {
		computer.start();		
	}
	

}
