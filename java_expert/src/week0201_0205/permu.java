package week0201_0205;

import java.util.Arrays;

public class permu {
	
	static int N = 3;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) {
		
		numbers = new int[3];
		isSelected = new boolean[4];
		
		perm(0);
	}
	
	public static void perm(int cnt) {
		
		if ( cnt == 3) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 1; i <= N ; i++) {
			if( isSelected[i] ) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
		
	}
}
