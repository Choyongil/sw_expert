package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3 {

	static int n, m, map[][], ans;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static List<Virus> list;
	static int[] index;
	static class Virus {
		int r, c;

		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		list = new ArrayList<>();		// 바이러스들을 저장할 리스트
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) list.add(new Virus(i,j));
			}
		}
		index = new int[m];				// 활성화된 바이러스를 저장할 배열
		ans = 987654321;
		
		active(0, 0);
		System.out.println(ans == 987654321 ? -1 : ans);
	}
	
	// 활성화할 바이러스 고르기
	public static void active(int idx, int cnt) {
		
		if(cnt == m) {
			int time = spread();
			if(time >= 0) ans = Math.min(ans, time);
			return;
		}
		
		for(int i = idx ; i < list.size() ; i++) {
			index[cnt] = i;
			active(i + 1, cnt + 1);
		}
	}
	
	// 바이러스를 퍼뜨릴 함수
	public static int spread() {
		
		int[][] tmp = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		Queue<Virus> queue = new LinkedList<>();
		
		// 초기에 활성화된 바이러스들을 큐에 넣어준다. 
		for(int i = 0 ; i < m ; i++) {
			Virus v = list.get(index[i]);
			queue.add(new Virus(v.r, v.c));
			tmp[v.r][v.c] = 3; 
		}
		
		int time = 0;
		int virus = queue.size();

		while(true) {

			time++;
			// time 이 현재 ans 보다 같거나 크다면 break
			if(time >= ans) break;
			
			for(int i = 0 ; i < virus ; i++) {
				
				Virus v = queue.poll();
				
				for(int d = 0 ; d < 4 ; d++) {
					int nr = v.r + dr[d];
					int nc = v.c + dc[d];
					
					// 벽과 이미 바이러스가 퍼진 구역은 continue
					if(nr < 0 || nr >= n || nc < 0 || nc >= n || tmp[nr][nc] == 1 || tmp[nr][nc] == 3) continue;
					tmp[nr][nc] = 3;
					queue.add(new Virus(nr, nc));
				}
			}
			
			// 0이 없다면 break
			if(check(tmp)) break;
			
			// 0이 있는데 퍼질 구역이 없다면 모든 구역에 바이러스를 퍼뜨릴 수 없다.
			if(queue.isEmpty()) {
				time = -1;
				break;
			}
			
			// virus 갯수 최신화
			virus = queue.size();
			
		}
		
		return time;
	}
	
	// 0이 있다면 return false 
	public static boolean check(int[][] tmp) {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(tmp[i][j] == 0) return false;
			}
		}
		return true;
	}
}
