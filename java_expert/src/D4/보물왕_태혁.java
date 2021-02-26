package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보물왕_태혁 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			if(n == 1) {
				int a = Integer.parseInt(st.nextToken());
				sb.append(a*a).append("\n");
				continue;
			}
			int min = 987654321;
			int max = 0;
			for(int i = 0 ; i < n ; i++) {
				int x = Integer.parseInt(st.nextToken());
				min = Math.min(min, x);
				max = Math.max(max, x);
			}
			sb.append(max*min).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
