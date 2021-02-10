package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최적_경로 {

	static boolean[] isSelected;
	static int n;
	static int[] r_c;				//회사 r, 회사 c, 집 r, 집 c
	static ArrayList<int[]> list;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			
			r_c = new int[4];
			n = Integer.parseInt(br.readLine());
			isSelected = new boolean[n];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < 4 ; i ++) {
				r_c[i] = Integer.parseInt(st.nextToken());
			}

			list = new ArrayList<int[]>();
			for(int i = 0 ; i < n ; i++) {
				int[] tmp = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				list.add(tmp);
			}
			
			ans = Integer.MAX_VALUE;
			func(0, r_c[0], r_c[1], 0);
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
	
	public static void func(int cnt, int r, int c, int sum) {
		
		
		if ( ans <= sum ) return;

		if (cnt == n) {
			sum += Math.abs(r_c[2] - r) + Math.abs(r_c[3] - c);
			
			ans = Math.min(ans, sum);
			
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {

			if(isSelected[i]) continue;
			
			if (!isSelected[i]) {
				isSelected[i] = true;
				int tmp_sum = Math.abs(list.get(i)[0] - r) + Math.abs(list.get(i)[1] - c);
				func(cnt+1, list.get(i)[0], list.get(i)[1], sum + tmp_sum);
				isSelected[i] = false;
			}
		}
	}
}
