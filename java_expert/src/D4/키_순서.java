package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키_순서 {

	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			arr = new int[n+1][n+1];
			int[] check = new int[n+1];
			
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				arr[s][e] = 1;
				check[e]++;
			}
			
			int ans = 0;
			
			for(int i = 1 ; i <= n ; i++) {
				
				Queue<Integer> queue = new LinkedList<>();
				boolean[] visited = new boolean[n+1];

				queue.add(i);
				visited[i] = true;
				
				// 작거나 큰 갯수 찾기
				int cnt = 0;
				
				// 더 큰 갯수 찾기
				while(!queue.isEmpty()) {
					int q = queue.poll();
					
					for(int j = 1 ; j <= n ; j++) {
						if(arr[q][j] == 1 && !visited[j]) {
							visited[j] = true;
							queue.add(j);
							cnt++;
						}
					}
				}
				
				queue.clear();
				visited = new boolean[n+1];
				queue.add(i);
				visited[i] = true;
				// 더 작은 갯수 찾기
				while(!queue.isEmpty()) {
					int q = queue.poll();
					
					for(int j = 1 ; j <= n ; j++) {
						if(arr[j][q] == 1 && !visited[j]) {
							visited[j] = true;
							queue.add(j);
							cnt++;
						}
					}
				}
				
				if(cnt == n-1) ans++;
				
			}
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}

/*
1
6
6
1 5
3 4
5 4
4 2
4 6
5 2
*/
