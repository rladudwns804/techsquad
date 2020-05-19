package stats;

public class StatsApp {

	public static void main(String args[]) {
		
		int[] a = {-30 , -1, 0, 3, 7, 8, 10, 12, 16, 20, 25, 27, 28, 32, 60};
		
		System.out.println(Stats.getMedian(a));
		System.out.println(Stats.getMean(a));
		System.out.println(Stats.getMode(a));
		
		System.out.println(Stats.testVariance(a));
		System.out.println(Stats.testStdDev(a));
	
		
	}
}
