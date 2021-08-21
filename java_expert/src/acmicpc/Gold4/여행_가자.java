package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 여행_가자 {

	static int parents[], n;
	static List<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		
		make();
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= n ; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					if(findSet(i) != findSet(j))
						union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int group = -1, city;
		String ans = "YES";
		for(int i = 0 ; i < m ; i++) {
			city = Integer.parseInt(st.nextToken());
			if(group == -1) group = parents[city];
			else if(group != parents[city]) {
				ans = "NO";
				break;
			}
		}
		System.out.println(ans);
	}
	
	public static void make() {
		for(int i = 1 ; i <= n ; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x == parents[x]) return x;
		
		return parents[x] = findSet(parents[x]);
	}
	
	public static void union(int a, int b) {
		int aRoot = parents[a];
		int bRoot = parents[b];
		if(aRoot == bRoot) return;
		
		if(aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		return;
			
	}
}
