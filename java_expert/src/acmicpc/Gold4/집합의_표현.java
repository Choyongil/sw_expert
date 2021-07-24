package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의_표현 {

	static int n, m, parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		make();
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				union(from, to);
			} else {
				if(findSet(from) == findSet(to)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void make() {
		for(int i = 0 ; i <= n ; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(parents[x] == x) return x;
		
		return parents[x] = findSet(parents[x]);
	}
	
	public static void union(int from, int to) {
		int f = findSet(from);
		int t = findSet(to);
		
		parents[t] = f;
	}
}
