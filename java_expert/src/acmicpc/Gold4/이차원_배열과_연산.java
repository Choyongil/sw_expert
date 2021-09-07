package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class 이차원_배열과_연산 {

	static int r, c, k, map[][], rLen, cLen;
	static class Point implements Comparable<Point>{
		int num, cnt;

		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		// cnt가 낮을수록, cnt가 같다면 num이 낮을수록 앞으로 정렬한다.
		@Override
		public int compareTo(Point o) {
			if(cnt == o.cnt) {
				if(num > o.num) return 1;
				return -1;
			} else {
				if(cnt > o.cnt) return 1;
				return -1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		map = new int[101][101];
		
		for(int i = 0 ; i < 3 ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < 3 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rLen = 3;
		cLen = 3;
		boolean dir;		// 행이 더 긴지 열이 더 긴지 확인할 변수
		
		int ans = 0;
		while(ans < 101) {
			// (r,c) 
			if(map[r][c] == k) break;

			int len = Math.max(rLen, cLen);
			dir = rLen >= cLen ? true : false;
			
			rLen = 0;
			cLen = 0;
			
			// 정렬하기
			for(int i = 0 ; i <= len ; i++) {
				sort(i, dir);
			}
			
			ans++;
			
		}
		System.out.println(ans == 101 ? -1 : ans);
	}
	
	public static void sort(int x, boolean flag) {
		
		List<Point> list = new ArrayList<>();
		int[] arr = new int[101];
		
		// num이 나온 cnt를 확인한다.
		if(flag) { 
			for(int i = 0 ; i < 101 ; i++) {
				
				if(map[x][i] == 0) continue;
				arr[map[x][i]]++;
			}
		} else {
			for(int j = 0 ; j < 101 ; j++) {
				
				if(map[j][x] == 0) continue;
				arr[map[j][x]]++;
			}
		}
		
		for(int i = 0 ; i < 101 ; i++) {
			if(arr[i] != 0) list.add(new Point(i, arr[i]));
		}
		
		Collections.sort(list);
		
		// flag 가 true 라면 행 정렬, false 라면 열 정렬
		// num 과 cnt 로 행렬을 채운다.
		for(int i = 0 ; i < 50 ; i++) {

			if(i >= list.size()) {
				// list.size를 벗어나면 모두 0으로 초기화 시켜준다.
				if(flag) {
					map[x][2 * i] = 0;
					map[x][2 * i + 1] = 0;
				} else {
					map[2 * i][x] = 0;
					map[2 * i + 1][x] = 0;
				}
			} else {
				// flag가 true라면 행을, false라면 열을 최신화시킨다.
				// num, cnt 순서대로 행렬을 채운다.
				if(flag) {
					map[x][2 * i] = list.get(i).num;
					map[x][2 * i + 1] = list.get(i).cnt;
					
					rLen = Math.max(rLen, x);
					cLen = Math.max(cLen, 2 * i + 1);
				} else {
					map[2 * i][x] = list.get(i).num;
					map[2 * i + 1][x] = list.get(i).cnt;
					
					rLen = Math.max(rLen, 2 * i + 1);
					cLen = Math.max(cLen, x);
				}
			}
		}
	}
}
