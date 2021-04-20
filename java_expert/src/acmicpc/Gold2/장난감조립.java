package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 장난감조립 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		int m = Integer.parseInt(br.readLine());
		
		int[] cnt = new int[n+1];
		int[] rev = new int[n+1];
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0 ; i <= m ; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		int[][] arr = new int[n+1][n+1];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			arr[x][y] = k;
			cnt[y]++;		// 나가는 갯수
			rev[x]++;		// 들어오는 갯수
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] ans = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			if(cnt[i] == 0) {
				queue.offer(i);
				ans[i] = 1;
			}
		}
		
		while(!queue.isEmpty()) {
			
			int q = queue.poll();
			
			for(int l : list.get(q)) {
				if(--cnt[l] == 0) {
					queue.offer(l);
				}
				ans[l] += arr[q][l] * ans[q];
			}
		}
		int[] result = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(arr[j][i] != 0) {
					result[i] += arr[j][i] * ans[j];
				}
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			if(rev[i] == 0) {
				sb.append(i).append(" ").append(result[i]).append("\n");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
