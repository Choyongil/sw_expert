package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의_높은_선반 {
	
	static int n, ans, hun;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			ans = 987654321;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			hun = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			go(0, 0);
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static void go(int idx, int sum) {
		
		if(sum > hun && sum - hun > ans) return;
		
		if(idx == n) {
			if (sum < hun) return;
			ans = Math.min(ans, Math.abs(sum - hun));
			return;
		}
		
		go(idx + 1, sum + arr[idx]);
		go(idx + 1, sum);

	}
}
