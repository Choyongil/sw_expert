package acmicpc.Gold5;

import java.util.Scanner;

public class 감소하는_수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans = -1;
		long cnt = 9;
		
		if(n < 10) {
			ans = n;
		} else if(n > 1022){
			ans = -1;
		} else if(n == 1022) {
			ans = 9876543210l;
		} else {
		
			// 10
			// 1 2 3 4 ... 9
			// 100
			// 0 1 3 6 
			// 1000
			// 0 0 1 4 

			int[][] dp = new int[2][10];
			boolean flag = false;
			int i2 = 0;
			for(int i = 1 ; i < 10 ; i++) {
				dp[0][i] = i;
				cnt += dp[0][i];
				if(cnt >= n) {
					flag = true;
					i2 = i;
					break;
				}
			}
			
			if(flag) {
				// 10 의 자리 수
				int num = (i2+1) * 10;
				cnt++;

				while(cnt != n) {
					num--;
					
					String str = Integer.toString(num);
					boolean ok = true;
					for(int i = 0 ; i < str.length() - 1 ; i++) {
						if(str.charAt(i) <= str.charAt(i + 1)) {
							ok = false;
							break;
						}
					}
					
					if(ok) {
						// 감소하는 수
						cnt--;
					}
					
					ans = num;
					
				}
				
			} else {
				
				int cntI = 2; // 자릿수
				int sizeJ = 0; // 첫자리 수
				int i = 0;
				out: while(true) {
					i = ( i + 1 ) % 2;
					for(int j = 1 ; j < 10 ; j++) {
						dp[i][j] = dp[(i + 1) % 2][j-1] + dp[i][j-1];
						cnt += dp[i][j];
						if(cnt >= n) {
							sizeJ = j;
							break out;
						}
					}
					cntI++;
				}
				
				long num = (sizeJ + 1) * (int) Math.pow(10, cntI);
				cnt++;
				while(cnt != n) {
					num--;
//					System.out.println(num);
					String str = Long.toString(num);
					boolean ok = true;
					for(int j = 0 ; j < str.length() - 1 ; j++) {
						if(str.charAt(j) <= str.charAt(j + 1)) {
							ok = false;
							break;
						}
					}
					
					if(ok) {
						// 감소하는 수
						cnt--;
					}
					
					ans = num;
					
				}
				
			}
			
		}
		System.out.println(ans);
	}
}
