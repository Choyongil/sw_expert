package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와_링크 {
	
	static int[][] arr;
	static int n, ans;
	static int[] s, l;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		ans = 987654321;
		arr = new int[n][n];
		s = new int[n / 2];
		l = new int[n / 2];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j < i) arr[j][i] += arr[i][j];
			}
		}
		set(0,0,0);
		System.out.println(ans);
	}
	
	public static void set(int cnt, int s_idx, int l_idx) {

		if(cnt == n) {
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i = 0 ; i < n / 2; i++) {
				for(int j = i+1 ; j < n / 2; j++) {
					sum1 += arr[s[i]][s[j]];
					sum2 += arr[l[i]][l[j]];
				}
			}
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			return;
		}
		
		if(s_idx < n / 2) {
			s[s_idx] = cnt;
			set(cnt+1, s_idx+1, l_idx);
		}
		if(l_idx < n / 2 ) {
			l[l_idx] = cnt;
			set(cnt+1, s_idx, l_idx+1);
		}
	}
}
