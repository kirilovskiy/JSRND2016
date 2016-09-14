package home.eighteenth.command;

public abstract class Command {
	abstract void Execute();
	abstract void UnExecute();
	abstract void PrintHistory();
}
