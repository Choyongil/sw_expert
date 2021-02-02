package week0201_0205;

import java.util.Arrays;

public class comb {
	
	static int N = 4;
	static int R = 3;
	static int[] numbers = new int[R];
	static int[] input = {1,2,3,4};
	
	public static void main(String[] args) {
		combi(0,0);
	}
	
	public static void combi(int cnt, int idx) {
		
		if ( cnt == R ) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for( int i = idx ; i < N ; i++) {
			numbers[cnt] = input[i];
			combi(cnt + 1, i + 1);
		}
	}
}
