package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 극한의_청소_작업 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			long m = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());
			
			int mL = Long.toString(m).length();
			int nL = Long.toString(n).length();
			int t = 0;		// m 부호 결정
			int t2 = 0;		// n 부호 결정
			if(m < 0) t = 1;
			if(n < 0) t2 = 1;
			
			long ans1 = 0;
			long ans2 = 0;
			long j = 1;
			for(int i = mL-1; i >= t ; i--, j *= 9) {
				long x = (Long.toString(m).charAt(i) - '0');
				if (x >= 4) x--;
				ans1 += x * j;
			}
			j = 1;
			for(int i = nL - 1; i >= t2 ; i--, j *= 9) {
				long x = (Long.toString(n).charAt(i) - '0');
				if (x >= 4) x--;
				ans2 += x * j;
			}
			long result = 0;
			if(t == 1 && t2 == 0) result = ans1 + ans2 - 1;
			else result = Math.abs(ans1 - ans2);
			sb.append(result).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}