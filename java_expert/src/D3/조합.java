package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합 {

	static int mod = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			long[] fac = new long[n + 1];
			fac[1] = 1;
			for(int i = 2 ; i <= n ; i++) {
				fac[i] = (fac[i-1] * i) % mod;
			}
			
			long ans = (fac[n] * mul((fac[r] * fac[n-r]) % mod, mod - 2)) % mod;
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	private static long mul(long n, int cnt) {
		
		if(cnt == 0) return 1;
		long tmp = mul(n, cnt / 2);
		long next = (tmp * tmp) % mod;
		if(cnt % 2 == 0) {
			return next;
		} else {
			return (next * n) % mod;
		} 
	}
}
