package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			// 건물 당 건설 시간 배열
			int[] times = new int[n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= n ; i++) 
				times[i] = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			for(int i = 0 ; i <= n ; i++) 
				list.add(new ArrayList<Integer>());
			
			int[] arr = new int[n+1];
			for(int i = 0 ; i < k ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				list.get(s).add(e);
				arr[e]++;
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] dp = new int[n+1];		// 각 건물 번호 당 건설에 걸리는 시간의 최솟값
			for(int i = 1 ; i <= n ; i++) {
				dp[i] = times[i];
				if(arr[i] == 0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int q = queue.poll();
				
				for(int i : list.get(q)) {
					dp[i] = Math.max(dp[i], times[i] + dp[q]);
					arr[i]--;
					
					if(arr[i] == 0) queue.add(i);
					
				}
			}
			int ans = Integer.parseInt(br.readLine());
			sb.append(dp[ans]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
}
