package D3;

import java.util.Scanner;

public class 기차_사이의_파리 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
			

		StringBuilder sb = new StringBuilder();
		
		for( int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc+ " ");
			
			double d = sc.nextDouble(); // 기차 사이의 거리
			double a = sc.nextDouble();	// a기차의 속도
			double b = sc.nextDouble(); // b기차의 속도
			double f = sc.nextDouble(); // 파리의 속도
			
			double ans = 0;			// 파리가 움직이는 거리
			double t = 0;
			double tmp = a;
			while(true) {
				
				if (tmp == b) tmp = a;
				else tmp = b;
				
				t = d / (tmp + f);
				ans += t * f;
				d -= t * (a + b);
				if (d <= 0.00000001) break;
			}
			
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
