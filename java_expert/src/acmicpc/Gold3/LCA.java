package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class LCA {

	static int n, parent[], depth[];
	static List<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		depth = new int[n + 1];
		list = new ArrayList[n + 1];			// node 별로 부모 노드의 수를 입력시킬 배열
		
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
		
		// depth와 parent를 설정
		dfs(1,1);
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(findParent(a,b)).append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		
	}
	
	public static void dfs(int node, int d) {
		
		depth[node] = d++;
		for(int x : list[node]) {
			if(depth[x] == 0) {
				dfs(x, d);
				parent[x] = node;
			}
		}
	}
	
	public static int findParent(int a, int b) {
		
		
		if(depth[a] > depth[b]) {
			while(depth[a] != depth[b]) {
				a = parent[a];
			}
		} else if(depth[a] < depth[b]) {
			while(depth[a] != depth[b]) {
				b = parent[b];
			}
		}
		
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
}
