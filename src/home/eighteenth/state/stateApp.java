package home.eighteenth.state;

public class stateApp {
	public static void main(String[] args){
		Human human = new Human();
		human.setState(new ActivityWork());
		for(int i = 0; i < 10; i++){
			human.doSomething();
		}
	}

}
