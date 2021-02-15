package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알_덴테_스파게티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			
			for(int x : arr) {
				boolean flag = false;
				int t = x;
				while(x <= b + e) {
					if( b - e <= x && x <= b + e ) {
						flag = true;
						break;
					}
					x += t;	
				}
				if(flag) ans += 1;
			}
			
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
