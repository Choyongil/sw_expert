package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서 {

	static int n, m, map[][], ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		int a, b;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
		}
		
		ans = 0;
		for(int i = 1 ; i <= n ; i++) {
			if(checkTall(i)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean checkTall(int x) {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] check = new boolean[n + 1];
		
		queue.add(x);
		check[x] = true;
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			
			int q = queue.poll();
			
			for(int i = 1 ; i <= n ; i++) {
				if(!check[i] && map[q][i] == 1) {
					queue.add(i);
					check[i] = true;	
					cnt++;
				}
			}
			
		}
		
		queue.clear();
		queue.add(x);
		
		while(!queue.isEmpty()) {
			
			int q = queue.poll();
			
			for(int i = 1 ; i <= n ; i++) {
				if(!check[i] && map[i][q] == 1) {
					queue.add(i);
					check[i] = true;	
					cnt++;
				}
			}
			
		}
		
		return cnt == n ? true : false;
	}
}
