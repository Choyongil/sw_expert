package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공항 {
	
	static int n, m, parent[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		parent = new int[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			parent[i] = i;
		}
		
		int ans = 0;
		for(int i = 0 ; i < m ; i++) {
			
			int p = Integer.parseInt(br.readLine());
			
			int pSet = findSet(p);
			
			if(pSet == 0) break;
			
			ans++;
			union(pSet, pSet - 1);
		}
		
		System.out.println(ans);
	}
	
	public static int findSet(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	public static void union(int a, int b) {
		
		int aSet = findSet(a);
		int bSet = findSet(b);
		
		if(aSet == bSet) return;
		
		parent[aSet] = bSet;
		
	}
}
