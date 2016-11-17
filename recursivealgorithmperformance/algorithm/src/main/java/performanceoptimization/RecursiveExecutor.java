package performanceoptimization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecursiveExecutor {
	
	public static void main(String[] args){
		ExecutorService es = Executors.newFixedThreadPool(100);
		for(int i = 0; i < 1000; i++){
			Runnable recursiveThread = new RecursiveThread(RecursivePerformanceThreadSafe.getInstance());
			es.execute(recursiveThread);
		}
		es.shutdown();
	}

}
