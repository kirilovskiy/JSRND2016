package home.eighteenth.commandComp;

public class ResetCommand extends Command{
	public ResetCommand(Computer computer) {
		super(computer); 
	}
	@Override
	public void execute() {
		computer.reset();
	}
}
