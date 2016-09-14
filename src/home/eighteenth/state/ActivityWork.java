package home.eighteenth.state;

public class ActivityWork implements Activity {
	private int count = 0;

	@Override
	public void doSomething(Human context) {
		if (count < 5) {
			System.out.println("working...");
			count++;
		}else {
			context.setState(new ActivityHoliday());
			context.doSomething();
		}

	}

}
