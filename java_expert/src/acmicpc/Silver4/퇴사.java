package acmicpc.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> arr = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(i + day > n) cost = 0;
			arr.add(new int[] {day, cost});
		}
		
		int dp[] = new int[n+5];
		int ans = 0;
		for(int i = n-1 ; i >= 0 ; i--) {
			dp[i] = Math.max(arr.get(i)[1] + dp[i + arr.get(i)[0]], dp[i + 1]);
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
