package home.eighteenth.commandComp;

public class CompApp {
	public static void main(String[] args){
		Computer computer = new Computer();
		User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));
		user.startComputer();
		user.stopComputer();
		user.resetComputer();
	}
}
