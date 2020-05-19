package stats;
import util.Util;

public class Stats {
	
	private static int iqr;
	private static int q1;
	private static int q3;
	

	
	public static int getIqr() {
		return iqr;
	}

	public static int getQ1() {
		return q1;
	}

	public static int getQ3() {
		return q3;
	}


	public static int getMedian(int[] num) {
	
		int median = 0;
		int place = num.length/2;
		
		int[] sorted = Util.sort(num);
		
		if(sorted.length%2!=0) {
			return median = sorted[place];
		}	
		else {
			median = ((sorted[place] + sorted[place +1])/2 );
			return median;
		}	
	}	
	


	public static int getMode(int[] num) {
		
		int maxcount = 0;
		int value = 0;
		
		for(int i = 0; i < num.length; i++) {
			
			int count = 0;
			
			for(int j = 0;  j < num.length; ++j) {
				if (num[i] == num[j]) {
					++count;
				}
			}
			if (count > maxcount) {
				maxcount = count;
				value = num[i];
			}
		}
		return value; 
	}
	
	public static int getMean(int[] num) {
		
		int median = 0;
		
		for(int i : num) {
			median += i;
		}
		median = median/num.length;
		return median;	
	}
	
	public static int testRange(int[] num) {
		int min = 0;
		int max = 0;
		int range = 0;
		for(int i = 0; i< num.length; i++) {
			
			for(int j = i+1; j<num.length; j++) {
				int temp = 0;
				if(num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}	
		min = num[0];
		max = num[num.length-1];
		range = max - min;
		return range;
	}
	
	public static int testVariance(int[] num) {
		int var = 0;
		int mean = getMean(num);
		for(int i: num) {
			
			var += (int) Math.pow(i-mean, 2);
		}
		
		return var/num.length;
	}
	
	public static int testStdDev(int[] num) {
		
		int variance = testVariance(num);
		
		return (int) Math.sqrt(variance);	
	}
	
	public static void testIQR(int[] num) {
		int[] sorted = Util.sort(num);
		int size = num.length/2;
		int[] arrayq1= new int[size]; 
		int[] arrayq3 = new int[size];
		int q1Median = 0;
		int q3Median = 0;
		int count = 0;
			
		for(int i =0; i < size; i++) {
			arrayq1[i] = sorted[i];	
		}
	
		for(int i = num.length - 1; i > size; i-- ) {			
			arrayq3[count] = sorted[i];
			count++;
		}
		
		q1Median = getMedian(arrayq1);
		q3Median = getMedian(arrayq3);
		iqr = q3Median - q1Median;
		q1 = (int) (q1Median-1.5*iqr);
		q3 = (int) (q3Median+1.5*iqr);		
	}	
}
