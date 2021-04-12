package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 활주로_건설 {

	static int n, x, ans;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); 
			x = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			
			for(int i = 0 ; i < n ; i++) {
				goH(i);
				goV(i);
			}
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	// 세로 탐색
	private static void goV(int c) {
		
		boolean flag = true;
		
		visited = new boolean[n];
		out :for(int r = 0 ; r < n - 1 ; r++) {
			int s = arr[r][c];
			int e = arr[r+1][c];
			
			if(s == e ) continue;
			else if(s + 1 == e) {
				
				if(r + 1 - x < 0) {
					flag = false;
					break out;
				} else {
					for(int i = 0 ; i < x ; i++) {
						if(visited[r-i] || arr[r-i][c] != arr[r][c]) {
							flag = false;
							break out;
						}
						visited[r-i] = true;
					}
				}
				
			} else if(s - 1 == e) {
				
				if(r + x >= n) {
					flag = false;
					break out;
				} else {
					for(int i = 1 ; i <= x ; i++) {
						if(visited[r+i] || arr[r+i][c] != arr[r+1][c]) {
							flag = false;
							break out;
						}
						visited[r+i] = true;
					}
				}
			} 
			else {
				flag = false;
				break out;
			}
			
		}
		if(flag) ans++;
	}

	// 가로 탐색
	private static void goH(int r) {
		
		boolean flag = true;
		
		visited = new boolean[n];
		out :for(int c = 0 ; c < n - 1 ; c++) {
			int s = arr[r][c];
			int e = arr[r][c+1];
			
			if(s == e ) continue;
			else if(s + 1 == e) {
				
				if(c + 1 - x < 0) {
					flag = false;
					break out;
				} else {
					for(int i = 0 ; i < x ; i++) {
						if(visited[c-i] || arr[r][c-i] != arr[r][c]) {
							flag = false;
							break out;
						}
						visited[c-i] = true;
					}
				}
				
			} else if(s - 1 == e) {
				
				if(c + x >= n) {
					flag = false;
					break out;
				} else {
					for(int i = 1 ; i <= x ; i++) {
						if(visited[c+i] || arr[r][c+i] != arr[r][c+1]) {
							flag = false;
							break out;
						}
						visited[c+i] = true;
					}
				}
			} 
			else {
				flag = false;
				break out;
			}
			
		}
		if(flag) ans++;
		
	}
}


/*
1
6 2
3 3 3 2 1 1
3 3 3 2 2 1
3 3 3 3 3 2
2 2 3 2 2 2
2 2 3 2 2 2
2 2 2 2 2 2
1
6 4
3 2 2 2 1 2
3 2 2 2 1 2
3 3 3 3 2 2
3 3 3 3 2 2
3 2 2 2 2 2
3 2 2 2 2 2
*/