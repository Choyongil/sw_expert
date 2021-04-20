package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임_개발 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 0 ; i <= n ; i++) {
			list.add(new ArrayList<>());
		}
		
		int[] arr = new int[n+1];
		int[] cnt = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int x = Integer.parseInt(st.nextToken());
				if(x == -1) break;
				list.get(x).add(i);
				cnt[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		int[] ans = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			if(cnt[i] == 0) {
				queue.offer(i);
			}
			ans[i] = arr[i];
		}

		while(!queue.isEmpty()) {
			
			int x = queue.poll();

			for(int l : list.get(x)) {
			
				if(--cnt[l] == 0) {
					queue.offer(l);
				}
				ans[l] = Math.max(arr[l] + ans[x], ans[l]);
			}
		}
		
		for(int i = 1 ; i <= n ; i++)
			System.out.println(ans[i]);
	
	}
}
