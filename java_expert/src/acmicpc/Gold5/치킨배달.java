package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

	static int n, m, map[][], dis[][], ans, numbers[];
	static List<int[]> list1, list2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		list1 = new ArrayList<>();		// 집 위치
		list2 = new ArrayList<>();		// 치킨집 위치
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) list1.add(new int[] {i,j});
				else if(map[i][j] == 2) list2.add(new int[] {i,j});
			}
		}

		dis = new int[list1.size()][list2.size()];
		for(int i = 0 ; i < list1.size() ; i++) {
			int r = list1.get(i)[0];
			int c = list1.get(i)[1];
			for(int j = 0 ; j < list2.size() ; j++) {
				int r2 = list2.get(j)[0];
				int c2 = list2.get(j)[1];
				dis[i][j] = Math.abs(r-r2) + Math.abs(c-c2);
			}
		}
		ans = 987654321;
		numbers = new int[m];
		go(0,0);
		System.out.println(ans);
		
	}
	
	public static void go(int cnt, int idx) {
		if(cnt == m) {
			int sum = 0;
			for(int i = 0 ; i < list1.size() ; i++) {
				int min = 987654321;
				for(int j : numbers) {
					min = Math.min(dis[i][j], min);
				}
				sum += min;
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i = idx ; i < list2.size() ; i++) {
			numbers[cnt] = i;
			go(cnt+1, i+1);
		}
	}
}
