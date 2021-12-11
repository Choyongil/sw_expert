package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회망_서비스 {

	static int n, dist[][];
	static List<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < n - 1 ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dist = new int[2][n + 1];
		
		dfs(1, -1);
		
		System.out.println(Math.min(dist[0][1], dist[1][1]));
	}
	
	public static void dfs(int cur, int parent) {
		
		dist[0][cur] = 0;
		dist[1][cur] = 1;
		
		for(int next : list[cur]) {
			
			if(next != parent) {
				dfs(next, cur);
				dist[0][cur] += dist[1][next];
				dist[1][cur] += Math.min(dist[0][next], dist[1][next]);
			}
			
		}
		
	}
}
