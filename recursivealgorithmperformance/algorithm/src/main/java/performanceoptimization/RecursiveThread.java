package performanceoptimization;

import java.util.Random;

public class RecursiveThread implements Runnable{
	
	private RecursivePerformanceThreadSafe rpts;
	
	public RecursiveThread(RecursivePerformanceThreadSafe rpts){
		this.rpts = rpts;
	}
	
	public void run(){
		Random random = new Random();
		int randomValue = random.nextInt(1000);
		System.out.println("The value of " + randomValue + " is: " + rpts.x(randomValue));
	}

}
