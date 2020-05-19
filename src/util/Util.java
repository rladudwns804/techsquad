package util;

public class Util {
	
	public static int[] sort(int[] num) {
		for(int i = 0; i < num.length; i++) {
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
}
