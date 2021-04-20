package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방향_전환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			int sR = Integer.parseInt(st.nextToken());
			int sC = Integer.parseInt(st.nextToken());
			int eR = Integer.parseInt(st.nextToken());
			int eC = Integer.parseInt(st.nextToken());
			
			int a = Math.abs(sR - eR);
			int b = Math.abs(sC - eC);
			int c = Math.max(a, b);
			int d = Math.min(a, b);
			int ans = 0;
			if(c % 2 == 0) {
				c /= 2;
				ans += 4 * c;
				if(d % 2 != 0) ans -= 1;
			} else {
				c = c / 2;
				ans += c * 4 + 1;
				if(d % 2 != 0) ans += 1;
			}
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
