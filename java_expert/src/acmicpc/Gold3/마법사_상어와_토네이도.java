package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마법사_상어와_토네이도 {

	static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    // 모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};       
	static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    // 모래가 퍼지는 y방향
               {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
	static int[] sand = {1,1,2,7,7,2,10,10,5};								 // 모래 양
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	static int[][] map;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve(n/2,n/2));
	}
	
	public static int solve(int x, int y) {
		
		int r = x;
		int c = y;
		int outSand = 0;		// map 밖으로 나가는 모래 양
		int cnt = 1;			// 지금 보고있는 방향으로 가는 횟수
		
		while(true) {
			
			for(int d = 0 ; d < 4 ; d++) {
				
				// 1,1,2,2 => 3,3,4,4 ... 식으로 현재 보고 있는 방향으로 움직이기 때문에 2번째 방향이 지나면 cnt에 1을 더한다.
				if(d == 2) cnt++;
				
				// cnt만큼 이동
				for(int i = 0 ; i < cnt ; i++) {
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= n || nc >= n) return outSand;

					int spreadSand = 0;				// 날아간 모래의 양
					for(int j = 0 ; j < 9 ; j++) {
						int newSandR = nr + dsx[d][j];
						int newSandC = nc + dsy[d][j];
						
						spreadSand += (map[nr][nc] * sand[j]) / 100;
						// 날아간 모래가 
						// map 밖이면 outSand에 더해주고
						// map 안이면 해당 구역에 더해준다.
						if(newSandR < 0 || newSandC < 0 || newSandR >= n || newSandC >= n) {
							outSand += (map[nr][nc] * sand[j]) / 100;
						} else {
							map[newSandR][newSandC] += (map[nr][nc] * sand[j]) / 100;
						}
						
					}
					
					// 알파 계산
					int nrAlpha = nr + dr[d];
					int ncAlpha = nc + dc[d];
					
					if(nrAlpha < 0 || ncAlpha < 0 || nrAlpha >= n || ncAlpha >= n) {
						outSand += (map[nr][nc] - spreadSand);
					} else {
						map[nrAlpha][ncAlpha] += map[nr][nc] - spreadSand;
					}
					
					map[nr][nc] = 0;
					r = nr;
					c = nc;
					
				}
			}
			
			cnt++;
			
		}
		
	}
}
