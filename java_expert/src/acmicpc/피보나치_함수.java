package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_함수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[] zeros = new int[41];
			int[] ones = new int[41];
			zeros[0] = 1;
			zeros[1] = 0;
			ones[0] = 0;
			ones[1] = 1;
			
			if (n == 0) {
				System.out.println(1 + " " + 0);
				continue;
			}
			else if(n == 1) {
				System.out.println(0 + " " + 1);
				continue;
			}
			else{
				for(int i = 2 ; i <= n ; i++) {
					zeros[i] = zeros[i - 1] + zeros[i - 2];
					ones[i] = ones[i - 1] + ones[i - 2];
				}
				System.out.println(zeros[n] + " " + ones[n]);
				continue;
			}
		}
		
	}
}
