package home.eighteenth.state;

public class ActivityHoliday implements Activity {
	private int count = 0; 
	
	@Override
	public void doSomething(Human context) {
		if (count < 3){
			System.out.println("having holidays");
			count++;
		} else {
			context.setState(new ActivityWork());
			context.doSomething();
		}
	}

}
