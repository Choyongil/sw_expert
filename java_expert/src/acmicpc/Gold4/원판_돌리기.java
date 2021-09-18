package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 원판_돌리기 {

	static int n, m, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[n + 2][m + 2];
		
		
		// 원판에 수를 채운다.
		for(int i = 1 ; i <= n ; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		Deque<Integer> dequeue;
		for(int t = 0 ; t < T ; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			dequeue = new ArrayDeque<>();
			
			if(d == 0) {
				k = m - k;
			}
			
			for(int i = 1 ; i <= n ; i++) {
				if((i % x) == 0) {
					
					for(int j = 1 ; j <= m ; j++) {
						dequeue.add(map[i][(j + k - 1) % m + 1]);
					}
					
					for(int j = 1 ; j <= m ; j++) {
						map[i][j] = dequeue.poll();
					}
					
				}
			}

			remove();
		}
		
		
		int ans = 0;
		for(int i = 0 ; i <= n + 1 ; i++) {
			for(int j = 0 ; j <= m + 1 ; j++) {
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static void remove() {
		
		Queue<int[]> queue = new LinkedList<>();
		double sum = 0;
		double cnt = 0;
		
		for(int i = 1 ; i <= n ; i++) {
			
			for(int j = 1 ; j <= m ; j++) {
				
				if(map[i][j] == 0) continue;
				
				sum += map[i][j];
				if(map[i][j] > 0) cnt++;
				
				if(map[i][j] == map[i][j - 1] || map[i][j] == map[i][j + 1] ||
						map[i][j] == map[i - 1][j] || map[i][j] == map[i + 1][j]) {
					queue.add(new int[]{i,j});
				}
				
				if((j == 1 || j == m) && map[i][1] == map[i][m]) queue.add(new int[]{i,j});
				
			}
			
		}
		
		if(queue.isEmpty()) {
			
			double mean = sum / cnt;
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= m ; j++) {
					
					if(map[i][j] == 0) continue;
					
					if(map[i][j] > mean) map[i][j]--;
					else if(map[i][j] < mean) map[i][j]++;
				}
			}
			
		} else {
		
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				
				map[q[0]][q[1]] = 0;
			}
		}
		
	}
}
