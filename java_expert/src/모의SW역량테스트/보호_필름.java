package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보호_필름 {

	static int d, w, k, arr[][], arr2[][], ans, one[], zero[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			arr = new int[d][w];
			arr2 = new int[d][w];
			for(int i = 0 ; i < d ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < w ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					arr2[i][j] = arr[i][j];
				}
			}

			ans = 987654321;
			one = new int[w];
			zero = new int[w];
			for(int i = 0 ; i < w ; i++) {
				one[i] = 1;
			}
			
			if(k == 1) ans = 0;
			else go(0,0);
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void go(int idx, int cnt) {
		if(cnt >= ans) return;
		if(check()) {
			ans = Math.min(cnt, ans);
			return;
		}
		if(idx == d) return;
		
		go(idx + 1, cnt);
		arr2[idx] = one;
		go(idx + 1, cnt + 1);
		arr2[idx] = arr[idx];
		arr2[idx] = zero;
		go(idx + 1, cnt + 1);
		arr2[idx] = arr[idx];
	}
	
	private static boolean check() {
		for(int j = 0 ; j < w ; j++) {
			int tmp = arr2[0][j];
			int cnt = 1;
			boolean flag = false;
			out :for(int i = 1 ; i < d ; i++) {
				if(arr2[i][j] == tmp) {
					cnt++;
				} else {
					tmp = arr2[i][j];
					cnt = 1;
				}
				
				if(cnt == k) {
					flag = true;
					break out;
				}
			
			}
			if(!flag) return false;
			
		}
		return true;
	}
}
