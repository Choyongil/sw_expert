package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지_안녕 {

	static int r, c, time, map[][], ans, cleanR;
	static Queue<int[]> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = 0;
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		queue = new LinkedList<>();
		for(int i = 0 ; i < r ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < c ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cleanR = i;
			}
		}
		
		for(int t = 1 ; t <= time ; t++) {
			
			// queue에 좌표 넣어주기
			for(int i = 0 ; i < r ; i++) {
				for(int j = 0 ; j < c ; j++) {
					if(map[i][j] > 0) queue.add(new int[] {i,j});
				}
			}
			int[][] tmp = spread();
			spin(tmp);
			copy(tmp);
		}
		System.out.println(ans + 2);
	}
	
	public static int[][] spread() {
		int[][] tmp = new int[r][c];
		tmp[cleanR][0] = -1;
		tmp[cleanR - 1][0] = -1;
		
		int[] dr = new int[] {-1,1,0,0};
		int[] dc = new int[] {0,0,-1,1};
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int sR = q[0];
			int sC = q[1];
			
			int cnt = 0;		// 확산될 수 있는 공간의 개수
			for(int d = 0 ; d < 4 ; d++) {
				int nr = sR + dr[d];
				int nc = sC + dc[d];
				
				// map 크기를 벗어나거나 공기청정기 위치일 때 continue
				if(nr < 0 || nc < 0 || nr >= r || nc >= c || (nc == 0 && (nr == cleanR - 1 || nr == cleanR))) continue;
				
				cnt++;
				tmp[nr][nc] += map[sR][sC] / 5;
			}
			tmp[sR][sC] += map[sR][sC] - map[sR][sC] / 5 * cnt;
		}
		
		return tmp;
	}
	
	public static void spin(int[][] tmp) {

		// 반시계방향으로 회전
		int vertex = tmp[0][c-1];
		
		// 아래 -> 위
		for(int k = 0 ; k < cleanR - 1 ; k++) {
			tmp[k][c - 1] = tmp[k + 1][c - 1];
		}
		// ->
		for(int k = c - 1 ; k > 0 ; k--) {
			tmp[cleanR - 1][k] = tmp[cleanR - 1][k - 1] == -1 ? 0 : tmp[cleanR - 1][k - 1];
		}
		// 위 -> 아래
		for(int k = cleanR - 1 ; k > 0 ; k--) {
			if(tmp[k][0] == -1) continue;
			tmp[k][0] = tmp[k - 1][0];
		}
		// <-
		for(int k = 0 ; k < c - 1 ; k++) {
			if(tmp[0][k] == -1) continue;
			tmp[0][k] = tmp[0][k + 1];
		}
		tmp[0][c-2] = vertex;
	
		// 시계방향으로 회전
		vertex = tmp[r-1][c-1];
		
		// 위 -> 아래
		for(int k = r - 1 ; k > cleanR ; k--) {
			tmp[k][c - 1] = tmp[k - 1][c - 1];
		}
		// ->
		for(int k = c - 1 ; k > 0 ; k--) {
			tmp[cleanR][k] = tmp[cleanR][k - 1] == -1 ? 0 : tmp[cleanR][k - 1];
		}
		// 아래 -> 위
		for(int k = cleanR + 1; k < r - 1; k++) {
			tmp[k][0] = tmp[k + 1][0];
		}
		// <-
		for(int k = 0 ; k < c - 1 ; k++) {
			tmp[r - 1][k] = tmp[r - 1][k + 1];
		}
		tmp[r - 1][c - 2] = vertex;
	}
	
	public static void copy(int[][] tmp){
		// copy & update ans
		ans = 0;
		for(int i = 0 ; i < r ; i++) {
			for(int j = 0 ; j < c ; j++) {
				map[i][j] = tmp[i][j];
				ans += tmp[i][j];
			}
		}
	}
}
