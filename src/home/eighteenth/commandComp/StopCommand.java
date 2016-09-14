package home.eighteenth.commandComp;

public class StopCommand extends Command{
	public StopCommand(Computer computer) {
		super(computer); 
	}
	@Override
	public void execute() {
		computer.stop();
	}
}
