package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 콩_많이_심기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			
			int n2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int n = Math.max(n2, m2);
			int m = Math.min(n2, m2);
			
			if(n + m == 3) ans = 2;
			else if(n == 2 && m == 2) ans = 4;
				else {
				int[][] arr = {{1,1,0,0},
						{1,1,0,0},
						{0,0,1,1},
						{0,0,1,1}};
				
				int x = n / 4;
				int x_r = n % 4;
				int y = m / 4;
				int y_r = m % 4;
				
				ans += 8 * x * y;
				int sum1 = 0;
				for(int i = 0 ; i < x_r ; i++) {
					for(int j = 0 ; j < 4 ; j++) {
						if(arr[j][i] == 1) sum1 += 1;
					}
				}
				ans += sum1 * y;
				int sum2 = 0;
				for(int i = 0 ; i < 4 ; i++) {
					for(int j = 0 ; j < y_r ; j++) {
						if(arr[j][i] == 1) sum2 += 1;
					}
				}
				ans += sum2 * x;
				for(int i = 0 ; i < x_r ; i++) {
					for(int j = 0 ; j < y_r ; j++) {
						if(arr[j][i] == 1) ans += 1;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
