package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_굴리기 {

	static int n, m, r, c, k, map[][], dice[];
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dice = new int[6];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dice = new int[6];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < k ; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			r += dr[x];
			c += dc[x];
			
			if(r < 0 || c < 0 || r >= n || c >= m) {
				r -= dr[x];
				c -= dc[x];
				continue;
			}
			go(x);
			
			if(map[r][c] == 0) {
				map[r][c] = dice[5];
			} else {
				dice[5] = map[r][c];
				map[r][c] = 0;
			}
			
			System.out.println(dice[0]);
		}
		
		
		
	}
	
	public static void go(int d) {
		int[] tmp = dice.clone();
		
		if( d == 1 ) {
			dice[0] = tmp[3];
			dice[2] = tmp[0];
			dice[3] = tmp[5];
			dice[5] = tmp[2];
		} else if( d == 2 ) {
			dice[0] = tmp[2];
			dice[2] = tmp[5];
			dice[3] = tmp[0];
			dice[5] = tmp[3];
		} else if( d == 3 ) {
			dice[0] = tmp[4];
			dice[1] = tmp[0];
			dice[4] = tmp[5];
			dice[5] = tmp[1];
		} else if( d == 4 ) {
			dice[0] = tmp[1];
			dice[1] = tmp[5];
			dice[4] = tmp[0];
			dice[5] = tmp[4];
		}
	}
}
