package home.eighteenth.state;

public class ActivityWork implements Activity {

	@Override
	public void doSomething(Human context) {
		System.out.println("working...");
		context.setState(new ActivityHoliday());
	}

}
