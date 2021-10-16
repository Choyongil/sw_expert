package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기4 {

	static int n, m, k, arr[][], map[][], rotate[][], order[], ans;
	static boolean[] selected;
	// 왼 아래 오른 위
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		arr = new int[n + 1][m + 1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate = new int[k][3];
		for(int i = 0 ; i < k ; i++) {
			st = new StringTokenizer(br.readLine());
			
			rotate[i][0] = Integer.parseInt(st.nextToken());
			rotate[i][1] = Integer.parseInt(st.nextToken());
			rotate[i][2] = Integer.parseInt(st.nextToken());
		}
		
		order = new int[k];
		selected = new boolean[k];
		ans = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(ans);
	}
	
	public static void perm(int cnt) {
		
		if(cnt == k) {
			
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= m ; j++) {
					map[i][j] = arr[i][j];
				}
			}
			
			for(int x : order) {
				rotate(rotate[x][0], rotate[x][1], rotate[x][2]);
			}
			ans = Math.min(ans, calc());
			
			return;
		}
		
		for(int i = 0 ; i < k ; i++) {
			if(selected[i]) continue;
			
			order[cnt] = i;
			selected[i] = true;
			perm(cnt + 1);
			selected[i] = false;
		}
		
	}
	
	public static int calc() {
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 1 ; i <= n ; i++) {
			
			int sum = 0;
			for(int j = 1 ; j <= m ; j++) {
				sum += map[i][j];
			}
			
			min = Math.min(min, sum);
		}
		
		return min;
	}
	
	public static void rotate(int r, int c, int t) {
		
		for(int x = 1 ; x <= t ; x++) {
			
			int RU = map[r - x][c + x];
			// 위
			for(int i = c + x ; i > c - x ; i--) {
				map[r - x][i] = map[r - x][i - 1];
			}
			
			// 왼
			for(int i = r - x ; i < r + x ; i++) {
				map[i][c - x] = map[i + 1][c - x];
			}
			
			// 아래
			for(int i = c - x ; i < c + x ; i++) {
				map[r + x][i] = map[r + x][i + 1];
			}
			
			// 오른
			for(int i = r + x ; i > r - x ; i--) {
				map[i][c + x] = map[i - 1][c + x];
			}
			
			map[r - x + 1][c + x] = RU;
		}
		
	}
}
