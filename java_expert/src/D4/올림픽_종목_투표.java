package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 올림픽_종목_투표 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			int[] arr2 = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < m ; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] result = new int[n]; 
			for(int x : arr2) {
				for(int i = 0 ; i < n ; i++) {
					if(arr[i] <= x) {
						result[i] += 1;
						break;
					}
				}
			}
			int ans = -1;
			int ans_idx = 0;
			for(int i = 0 ; i < n ; i++) {
				if(result[i] > ans) {
					ans = result[i];
					ans_idx = i;
				}
			}
			sb.append(ans_idx+1).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
