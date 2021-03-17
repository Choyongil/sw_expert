package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 은비의_동전뒤집기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		long[] arr = new long[1001];
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;
		
		long[] fac = new long[1001];
		fac[0] = 0;
		fac[1] = 1;
		fac[2] = 2;
		for(int i = 3; i < 1001 ; i++) {
			fac[i] = (i * fac[i-1]) % 1000000007;
		}
		
		for(int i = 3; i < 1001 ; i++) {
			arr[i] = (i * arr[i-1] + fac[i-1] * ( i / 2 )) % 1000000007;
		}
		
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			
			sb.append(arr[n]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
