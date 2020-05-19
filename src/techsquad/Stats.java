package techsquad;

public class Stats {

	public static int getMedian(int[] num) {
	
		int median = 0;
		int place = num.length/2;
		
		int[] sorted = sort(num);
		
		if(sorted.length%2!=0) {
			return median = sorted[place];
		}
		
		else {
			median = ((sorted[place] + sorted[place +1])/2 );
			return median;
		}
	
		
	}
	
	public static int[] sort(int[] num) {
		for(int i = 1; i < num.length; i++) {
			for(int j = i + 1;  j < num.length; j++) {
				if (num[i] > num[j]) {
					
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		return num;
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
	
	public static void testRange(int[] num) {
		int min = 0;
		int max = 0;
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
		System.out.println(min +" " + max);
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
		int[] sorted = sort(num);
		int size = num.length/2;
		int[] arrayq1= new int[size]; 
		int[] arrayq3 = new int[size];
		int q1 = 0;
		int q3 =0;
		int iqr = 0;
		int q1out = 0;
		int q3out = 0;
		int count = 0;
		System.out.println("size = " +size);
		
		for(int i =0; i < num.length/2; i++) {
			arrayq1[i] = num[i];
			System.out.println("number: " + num[i]);
		}
	
		for(int i = num.length - 1; i >= num.length/2; i-- ) {			
			arrayq3[count] = num[i];
			count++;
			System.out.println("q3 number: " + num[i] );
		}
		
		q1 = getMedian(arrayq1);
		q3 = getMedian(arrayq3);
		iqr = q3-q1;
		System.out.println("iqr" + iqr);
		System.out.println("q1 " + q1);
		System.out.println("q3 " + q3);
		q1out = (int) (q1+1.5*iqr);
		q3out = (int) (q3+1.5*iqr);
			
		System.out.println("Q1 outliers: " +  q1out + " Q3 outliers: " + q3out);
			
	}	
}
