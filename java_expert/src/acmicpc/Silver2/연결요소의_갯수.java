package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의_갯수 {
	
	static int[][] map;
	static boolean[] visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		visited = new boolean[n+1];
		visited[0] = true;
		int ans = 0;
		for(int i = 1 ; i <= n ; i++) {
			if(visited[i]) continue;
			ans += 1;
			func(i);
		}
		System.out.println(ans);
	}
	
	public static void func(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(idx);
		while(!queue.isEmpty()) {
			int q = queue.poll();
			visited[q] = true;
			for(int i = 1 ; i <= n ; i++) {
				if(!visited[i] && map[i][q] == 1) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}