package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와_BFS {

	static int[][] map;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		
		visited[v] = true;
		sb.append(v).append(" ");
		dfs(v, 1, sb);
		sb.setLength(sb.length()-1);
		sb.append("\n");
		
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.add(v);
		visited = new boolean[n+1];
		visited[v] = true;
		while(!queue.isEmpty()) {
			int q = queue.poll();
			sb.append(q).append(" ");
			for(int i = 1 ; i <= n ; i++) {
				if(map[q][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	private static void dfs(int v, int cnt, StringBuilder sb) {
		
		if( cnt == n ) return;
		for(int i = 1 ; i <= n ; i++) {
			if(map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1, sb.append(i).append(" "));
			}
		}
	}
}
