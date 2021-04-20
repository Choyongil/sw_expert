package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] times = new int[n+1];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 0 ; i <= n ; i++) {
			list.add(new ArrayList<>());
		}
		
		int[] cnt = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			times[i] = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < x ; j++) {
				int k = Integer.parseInt(st.nextToken());
				list.get(k).add(i);
				cnt[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int[] ans = new int[n+1];
		int y = 0;
		for(int i = 1 ; i <= n ; i++) {
			if(cnt[i] == 0) {
				queue.add(i);
			}
			ans[i] = times[i];
		}
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int l : list.get(x)) {
				if(--cnt[l] == 0) {
					queue.offer(l);
				}	
				ans[l] = Math.max(ans[x] + times[l], ans[l]);
			}
		}
		int max = 0;
		for(int a : ans) max = Math.max(a, max);
		System.out.println(max);
	}
}
