package acmicpc.Gold5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 숫자고르기 {

	static int n, map[];
	static List<Integer> list;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1];
		visited = new boolean[n+1];
		list = new ArrayList<>();
		
		for(int i = 1 ; i <= n ; i++) {
			map[i] = sc.nextInt();
		}

		for(int i = 1 ; i <= n ; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int x : list) System.out.println(x);
	}
	
	public static void dfs(int startIdx, int idx) {
		
		if(!visited[map[startIdx]]) {
			visited[map[startIdx]] = true;
			dfs(map[startIdx], idx);
			visited[map[startIdx]] = false;
		}
		
		if(map[startIdx] == idx) list.add(idx);
		
	}
}
