package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낚시왕 {

	static int r, c, m, map[][], ans;
	static shark[][] arr;
	static class shark{
		int id, r, c, s, d, z;

		public shark(int id, int r, int c, int s, int d, int z) {
			super();
			this.id = id;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static shark[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[r+1][c+1];
		list = new shark[m+1];
		for(int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());		// 속력
			int d = Integer.parseInt(st.nextToken());		// 방향
			if(d > 2) s = s % (2*c - 2);
			else s = s % (2*r - 2);
			int z = Integer.parseInt(st.nextToken());		// 크기
			map[r1][c1] = i;
			list[i] = new shark(i,r1,c1,s,d,z);
		}
		ans = 0;
		for(int i = 1 ; i <= c ; i++) {
			go(i);
			move();
		}
		System.out.println(ans);
	}
	
	public static void go(int loc) {
		
		for(int i = 1 ; i <= r ; i++) {
			if(map[i][loc] != 0) {
				ans += list[map[i][loc]].z;
				list[map[i][loc]] = null;
				return;
			}
		}
	}
	
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,1,-1};
	public static void move() {
		int[][] arr = new int[r+1][c+1];
		for(shark sh : list) {
			if(sh == null) continue;
			int r1 = sh.r;
			int c1 = sh.c;
			int s = sh.s;
			int d = sh.d;
			int z = sh.z;
			
			int nr = r1;
			int nc = c1;
			for(int i = 0 ; i < s ; i++) {
				if(d <= 2 ) {
					if(nr == 1 & d == 1) d = 2;
					else if(nr == r && d == 2) d = 1;
				} else {
					if(nc == 1 & d == 4) d = 3;
					else if(nc == c && d == 3) d = 4;
				}
				nr = nr + dr[d];
				nc = nc + dc[d];
			}
			if(arr[nr][nc] == 0) {
				arr[nr][nc] = sh.id;
				list[arr[nr][nc]] = new shark(sh.id,nr,nc,s,d,z);
			}
			else {
				if(list[arr[nr][nc]].z < z) {
					list[arr[nr][nc]] = null;
					arr[nr][nc] = sh.id;
					list[sh.id] = new shark(sh.id,nr,nc,s,d,z);
				} else {
					list[sh.id] = null;
				}
			}
		}
		for(int i = 1 ; i <= r ; i++) {
			for(int j = 1 ; j <= c ; j++) {
				map[i][j] = arr[i][j];
			}
		}
	}
}
