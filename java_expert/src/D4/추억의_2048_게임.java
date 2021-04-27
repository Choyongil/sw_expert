package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 추억의_2048_게임 {

	static int n, map[][];
	static String dir;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append("\n");
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			map = new int[n][n];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			go();
			for(int[] arr : map) {
				for(int a : arr) sb.append(a).append(" ");
				sb.append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	public static void go() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int tmp;
		switch (dir) {
		case "up":
			for(int j = 0 ; j < n ; j++) {
				for(int i = 0 ; i < n ; i++) {
					tmp = -1;
					if(map[i][j] != 0) {
						tmp = map[i][j];
					}
					for(int k = i + 1; k < n ; k++) {
						if(map[k][j] != 0) {
							if(tmp == map[k][j]) {
								map[i][j] = tmp*2;
								map[k][j] = 0;
								i = k;
							}
							break;
						}
					}
				}

				for(int i = 0 ; i < n ; i++) {
					if(map[i][j] != 0) {
						queue.offer(map[i][j]);
						map[i][j] = 0;
					}
				}
				int size = queue.size();
				for(int i = 0 ; i < size ; i++) {
					map[i][j] = queue.poll();
				}
				
			}
			break;

		case "down":
			for(int j = 0 ; j < n ; j++) {
				for(int i = n-1 ; i >= 0 ; i--) {
					tmp = -1;
					if(map[i][j] != 0) {
						tmp = map[i][j];
					}
					for(int k = i - 1; k >= 0 ; k--) {
						if(map[k][j] != 0) {
							if(tmp == map[k][j]) {
								map[i][j] = tmp*2;
								map[k][j] = 0;
								i = k;
							}
							break;
						}
					}
				}

				for(int i = n-1 ; i >= 0 ; i--) {
					if(map[i][j] != 0) {
						queue.offer(map[i][j]);
						map[i][j] = 0;
					}
				}
				int size = queue.size();
				for(int i = 0 ; i < size ; i++) {
					map[n - 1 - i][j] = queue.poll();
				}
				
			}
			break;
		case "left":
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					tmp = -1;
					if(map[i][j] != 0) {
						tmp = map[i][j];
					}
					for(int k = j + 1; k < n ; k++) {
						if(map[i][k] != 0) {
							if(tmp == map[i][k]) {
								map[i][j] = tmp*2;
								map[i][k] = 0;
								j = k;
							}
							break;
						}
					}
				}

				for(int j = 0 ; j < n ; j++) {
					if(map[i][j] != 0) {
						queue.offer(map[i][j]);
						map[i][j] = 0;
					}
				}
				int size = queue.size();
				for(int j = 0 ; j < size ; j++) {
					map[i][j] = queue.poll();
				}
				
			}
			break;

		case "right":
			for(int i = 0 ; i < n ; i++) {
				for(int j = n-1 ; j >= 0 ; j--) {
					tmp = -1;
					if(map[i][j] != 0) {
						tmp = map[i][j];
					}
					for(int k = j - 1; k >= 0 ; k--) {
						if(map[i][k] != 0) {
							if(tmp == map[i][k]) {
								map[i][j] = tmp*2;
								map[i][k] = 0;
								j = k;
							}
							break;
						}
					}
				}

				for(int j = n-1 ; j >= 0 ; j--) {
					if(map[i][j] != 0) {
						queue.offer(map[i][j]);
						map[i][j] = 0;
					}
				}
				int size = queue.size();
				for(int j = 0 ; j < size ; j++) {
					map[i][n - 1 - j] = queue.poll();
				}
				
			}
			break;
		}
	}
}
/*

2
2 left
2 2
4 4
2 right
2 2
4 4
*/