package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한빈이와_spot_mart {

	static int n;
	static int m;
	static boolean[] isSelected;
	static int[] arr;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine(), " " );
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			isSelected = new boolean[n];
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			powerset(0, 0, 0);
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
		
	}
	
	static public void powerset(int idx, int cnt, int sum) {
		
		if (idx == n) {
			if( m < sum ) return;
			else if ( sum == 0 && ans <= 0) {
				ans = -1;
				return;
			}
			else {
				if (cnt == 1 && ans <= 0) {
					ans = -1;
				}
				else ans = Math.max(ans, sum);
			}
			return;
		}
		
		isSelected[idx] = true;
		powerset(idx+1, cnt + 1, sum + arr[idx]);
		isSelected[idx] = false;
		powerset(idx+1, cnt, sum);
	}
}
