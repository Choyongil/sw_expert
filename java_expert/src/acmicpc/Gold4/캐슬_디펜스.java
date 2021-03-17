package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 캐슬_디펜스 {

	static int[] input, numbers;
	static int n, m, d, ans;
	static int[][] arr, arr2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		numbers = new int[3];
		input = new int[m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				input[j] = j;
			}
		}
		
		ans = 0;
		set(0,0);
		
		System.out.println(ans);
	}

	// 궁수들의 위치 배치
	private static void set(int cnt, int idx) {
		
		if(cnt == 3) {
			go();
			return;
		}
		
		for(int i = idx ; i < m ; i++) {
			numbers[cnt] = input[i];
			set(cnt + 1, i + 1);
		}
		return;
	}

	// 적 죽이기
	private static void go() {
		
		ArrayList<int[]> set = new ArrayList<int[]>();
		int sum = 0;
		arr2 = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		
		if(d == 1) {
			for(int i = 0 ; i < n ; i++) {
				sum += arr[i][numbers[0]] + arr[i][numbers[1]] + arr[i][numbers[2]];
			}
		}
		else {
			while(!check()) {
				
				for(int archer = 0 ; archer < 3 ; archer++) {
					int dis = d;
					int r = 987654321, c = 987654321;
					for(int i = 0 ; i < n ; i++) {
						for(int j = 0 ; j < m ; j++) {
							if(arr2[i][j] == 1 && dis >= ((n - i) + Math.abs(numbers[archer] - j))){
								if(dis == (n - i) + Math.abs(numbers[archer] - j)) {
									if(j < c) {
										dis = (n - i) + Math.abs(numbers[archer] - j);
										r = i;
										c = j;									
									}
								} else {
									dis = (n - i) + Math.abs(numbers[archer] - j);
									r = i;
									c = j;
								}
							}
						}
					}
					if(r != 987654321 && c != 987654321) set.add(new int[] {r, c});
				}
				
				for(int[] a: set) {
					if(arr2[a[0]][a[1]] == 1) {
						sum++;
						arr2[a[0]][a[1]] = 0;
					}
				}
	
				set.clear();
				down();
			}
		}
		ans = Math.max(sum, ans);
	}
	
	// 남아있는 적이 있는지 확인
	private static boolean check() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(arr2[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	// 적 위치 하나씩 내리기
	private static void down() {
		for(int i = n - 1 ; i > 0 ; i--) {
			for(int j = 0 ; j < m ; j++) {
				arr2[i][j] = arr2[i-1][j];				
			}
		}
		for(int i = 0 ; i < m ; i++) {
			arr2[0][i] = 0;
		}
	}
}
