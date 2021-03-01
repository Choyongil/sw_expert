package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ladder2 {
	static int MAX = 100, ans, ans_idx;
	static int[][] map;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();

			map = new int[MAX][MAX];
			list = new ArrayList<Integer>();
			
			for(int i = 0; i < MAX; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < MAX; j++) { 
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 && map[i][j] == 1) list.add(j);
				}
			}

			ans = 987654321;
			ans_idx = -1;
			for(int i = 0 ; i < list.size() ; i++) {
				go(0, i, i, 0);
			}
			sb.append("#").append(tc).append(" ").append(ans_idx).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static void go(int r, int start_c, int c2, int sum) {
		
		if(sum > ans) return;
		
		if(r == MAX - 1) {
			if(ans >= sum) {
				ans = sum;
				ans_idx = list.get(start_c);
			}
			return;
		}
		
		int c = list.get(c2);
		if(c > 0 && map[r + 1][c - 1] == 1) go(r + 1, start_c, c2 - 1, sum + list.get(c2) - list.get(c2 - 1) + 1);
		else if(c < MAX - 1 && map[r + 1][c + 1] == 1) go(r + 1, start_c, c2 + 1, sum + list.get(c2+1) - list.get(c2) + 1);
		else go(r + 1, start_c, c2, sum + 1);
	}
}
