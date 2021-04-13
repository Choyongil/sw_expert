package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_빠른_문자열_타이핑 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			String t = st.nextToken();
			String p = st.nextToken();

			int cnt = 0;
			
			for(int i = 0 ; i < t.length() ; i++) {
				if(i + p.length() - 1 < t.length()) {
					String temp = t.substring(i, i + p.length());
					if(temp.equals(p)) {
						cnt++;
						i += p.length() - 1;
					}
				}
			}
			
			int ans = t.length() - cnt * p.length() + cnt;
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
