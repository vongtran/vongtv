package performanceoptimization;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecursivePerformance {
	
	private static Map<Integer, Double> initiatedValue;
	private static RecursivePerformance instance;
	
	static{
		initiatedValue = new LinkedHashMap<Integer, Double>();
		initiatedValue.put(0, new Double(1));
		initiatedValue.put(1, new Double(1));
		instance = new RecursivePerformance();
	}
	
	private RecursivePerformance(){
		
	}
	
	public static RecursivePerformance getInstance(){
		return instance;
	}
	
	/**
	 * This function is to sum up 2 previous function's value as this formula: function x(y) = function x(y-1) + function x(y-2)
	 * @param y
	 * @return x(y) = x(y-1) + x(y-2)
	 * @throws IllegalArgumentException if y is a negative value
	 */
	public double x(int y) throws IllegalArgumentException{
		double currentValue = -1;
		if(y < 0){
			throw new IllegalArgumentException("Value y must greater than 0");
		}
		if(initiatedValue.containsKey(y)){
			currentValue = initiatedValue.get(y);
		}else{
			int currentSize = initiatedValue.size();
			int loopCount = 0;
			while(currentSize <= y){
				currentValue = sum(initiatedValue.get(currentSize-1), initiatedValue.get(currentSize-2));
				initiatedValue.put(currentSize, currentValue);
				currentSize++;
				loopCount++;
			}
			System.out.println("Loop count: " + loopCount);
		}
		return currentValue;
		
	}
	/**
	 * This function to sum two value a and b
	 * @param a
	 * @param b
	 * @return a+b
	 */
	private double sum(double a, double b){
		return a + b;
	}

	public static void main(String[] args) {
		RecursivePerformance rpf = RecursivePerformance.getInstance();
		System.out.println("Value of 10: " + rpf.x(10));
		System.out.println("Value of 54: " + rpf.x(54));
		System.out.println("Value of 100: " + rpf.x(100));
		System.out.println("Value of 1000: " + rpf.x(1000));
		System.out.println("Value of 900: " + rpf.x(900));
		RecursivePerformance rpf2 = RecursivePerformance.getInstance();
		System.out.println("Value of 500: " + rpf2.x(500));
		
	}

}
