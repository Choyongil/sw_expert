package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		int ans = 0;
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			for(int i = 1 ; i <= n ; i++) {
				if( !visited[i] && arr[q][i] == 1) {
					queue.offer(i);
                    ans += 1;
					visited[i] = true;
				}
			}
		}
		
		System.out.println(ans - 1);
		
	}
}
