package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링 {

	static int n, total, ans;
	static int[] arr;
	static int[][] connect;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		total = 0;				// 모든 인구 수의 합
		arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}

		connect = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; j < e ; j++) {
				int t = Integer.parseInt(st.nextToken());
				connect[i][t] = 1;
			}
		}
		
		if(n == 2) {
			System.out.println(Math.abs(arr[1] - arr[2]));
		} else {
			ans = Integer.MAX_VALUE;
			visited = new boolean[n+1];
			set(1);
			
			System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		}
	}
	
	// 두 쌍을 다 구하기
	private static void set(int idx) {
		if(idx == n+1) {
			if(checking()) {
				int s = solve();
				ans = Math.min(ans, s);
			}
			
			return;
		}
		
		visited[idx] = true;
		set(idx+1);
		visited[idx] = false;
		set(idx+1);
	}
	
	// 가능한 나눔인지 확인
	private static boolean checking() {
		
		// 하나의 그룹이면 false
		int cnt = 0;
		int s1 = 0;
		int s2 = 0;
		for(int i = 1 ; i <= n ; i++) {
			if(visited[i]) {
				cnt++;
				s1 = i;
			} else {
				s2 = i;
			}
		}
		if(cnt == n || cnt == 0) return false;
		
		// 두 개의 그룹이 각자 안 이어져있으면 false
		boolean[] check = new boolean[n+1];
		int num = 2;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s1);
		check[s1] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i = 1 ; i <= n ; i++) {
				if(visited[i] && connect[x][i] == 1 && !check[i]) {
					num++;
					check[i] = true;
					queue.add(i);
				}
			}
		}
		
		check = new boolean[n+1];
		queue = new LinkedList<>();
		queue.add(s2);
		check[s2] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i = 1 ; i <= n ; i++) {
				if(!visited[i] && connect[x][i] == 1 && !check[i]) {
					num++;
					check[i] = true;
					queue.add(i);
				}
			}
		}
		
		if(num != n) return false;
		
		return true;
	}

	// 가능하면 두 그룹 간의 차 구하기
	private static int solve() {
		
		int sum = 0;
		for(int i = 0 ; i <= n ; i++) {
			if(visited[i]) sum += arr[i];
		}
		return Math.abs((total - sum) - sum);
	}
}
