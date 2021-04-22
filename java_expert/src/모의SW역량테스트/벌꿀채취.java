package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 벌꿀채취 {

	static int n, m, c, arr[][], ans, amount[][];
	
	static class Point implements Comparable<Point>{
		int r, c, num;

		public Point(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			return o.num - this.num;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			ans = 0;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			amount = new int[n][n];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			go();
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	private static void go() {
		
		List<Point> list = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= n - m ; j++) {
				int[] tmp = new int[m];
				for(int k = j ; k < j + m ; k++) {
					tmp[k-j] = arr[i][k];
				}
				profit(tmp, 0, 0, c, i, j);
				if(amount[i][j] > 0) {
					list.add(new Point(i,j,amount[i][j]));
				}
			}
		}
		
		Collections.sort(list);

		for(int i = 0 ; i < list.size() ; i++) {
			int r1 = list.get(i).r;
			int c1 = list.get(i).c;
			int s1 = list.get(i).num;
			for(int j = i+1 ; j < list.size() ; j++) {
				int r2 = list.get(j).r;
				int c2 = list.get(j).c;
				int s2 = list.get(j).num;

				if(r1 != r2) {
					ans = Math.max(s1 + s2, ans);
				} else if(r1 == r2) {
					if(c1 + m - 1 < c2) {
						ans = Math.max(s1 + s2, ans);
					}
				}
			}
		}
	}
	
	private static void profit(int[] a, int idx, int sum, int total, int r, int c) {

		if(idx == m) {
			amount[r][c] = Math.max(sum, amount[r][c]);
			return;
		}
		
		if(total - a[idx] >= 0) profit(a, idx + 1, sum + (a[idx] * a[idx]), total - a[idx], r, c);
		profit(a, idx + 1, sum, total, r, c);
		
		return;
	}
}
