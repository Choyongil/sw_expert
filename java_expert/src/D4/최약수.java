package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최약수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		// 1, 2, 5
		// 10, 20, 25, 50
		// 100, 125, 200, 250, 500
		// ...
		int[][] arr = {{1,2,5},{10,20,20,50},{100,125,200,250,500}};
		
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			
			int k = Integer.toString(n).length() - 1;
			int ans = 0;

			if(k == 0) {
				for(int i = 0 ; i < 3 ; i++) {
					if(arr[0][i] <= n) ans += 1;
				}
			} else if (k == 1) {
				ans += 3;
				for(int i = 0 ; i < 4 ; i++) {
					if(arr[1][i] <= n) ans += 1;
				}
			} else {
				ans += 7;
				ans += 5 * (k-2);
				for(int i = 0 ; i < 5 ; i++) {
					if(arr[2][i]*Math.pow(10, (k-2)) <= n) ans += 1;
				}
			}
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
