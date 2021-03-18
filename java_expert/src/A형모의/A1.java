package A형모의;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A1{
	
	static int n, ans, total, ans_cnt;
	static int[][] arr;
	static ArrayList<int[]> list;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
   
		int T = Integer.parseInt(br.readLine());
   
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" " );
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			// 최종 core 개수
			ans = 0;
			// 최종 전선 길이 합
			ans_cnt = 987654321;
			// 전선 길이 합
			total = 0;
			list = new ArrayList<int[]>();
			
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1 && i != 0 && j != 0 && i != n-1 && j != n-1) {
						list.add(new int[] {i,j});
					}
				}
			}

			go(0,0);
			sb.append(ans_cnt == 987654321? 0 : ans_cnt).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = { 0, 0, 1, -1};
	public static void go(int index, int sum) {
		
		
		if(index == list.size()) {
			
			if(ans < sum) {
				ans = sum;
				ans_cnt = total;
			} else if(ans == sum) {
				ans_cnt = Math.min(ans_cnt, total);
			}
			return;
		}
		
		int r = list.get(index)[0];
		int c = list.get(index)[1];
		
		for(int d = 0 ; d < 4 ; d++) {

			if(check(r,c,d)) {
				
				change(r,c,d,2);
				sum++;
				
				System.out.println("r : " + r + " c : " + c + " sum : " + sum);
				for(int[] a : arr) System.out.println(Arrays.toString(a));
				System.out.println();
				go(index+1, sum);
				
				change(r,c,d,0);
				sum--;
				
			}
		}
		go(index + 1, sum);
		
		return;
	}
	
	public static boolean check(int r, int c, int d) {
		
		while(true) {
			
			r += dr[d];
			c += dc[d];

			if( r < 0 || c < 0 || r >= n || c >= n) break;
			
			if(arr[r][c] > 0) return false;
		}
		
		return true;
	}
	
	public static void change(int r, int c, int d, int num) {
		while(true) {
			
			r += dr[d];
			c += dc[d];

			if( r < 0 || c < 0 || r >= n || c >= n) return;
			
			arr[r][c] = num;

			if(num == 2) {
				total++;
			}
			if(num == 0) {
				total--;
			}
			
		}
	}
}

