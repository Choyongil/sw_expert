package D3;

import java.util.Scanner;

public class 정삼각형_분할_놀이 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for( int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			long n = sc.nextLong();
			long m = sc.nextLong();
			
			long ans = 0l;
			
			for( int i = 1 ; i <= n / m ; i++) {
				ans += 2 * i - 1;
			}
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
