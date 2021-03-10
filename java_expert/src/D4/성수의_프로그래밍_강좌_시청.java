package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 성수의_프로그래밍_강좌_시청 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" " );
			
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			double ans = 0;
			Arrays.sort(arr);
			for(int i = n - k ; i < n ; i++) {
				ans = (ans + arr[i]) / 2;
			}
			sb.append(String.format("%.6f", ans)).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
