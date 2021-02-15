package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 몬스터_사냥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine(), " ");
			long D = Long.parseLong(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			long ans = D * N + D * L * N * (N-1) / 200;

//			long ans = 0;
//			for(int n = 0 ; n < N ; n++) {
//				ans += D * (1 + ((double) (n * L)) / 100);
//			}
			
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
					
		}	
	}
}
