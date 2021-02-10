package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빠른_휴대전화_키패드 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for( int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " " );
			
			st = new StringTokenizer(br.readLine(), " ");
			String input = st.nextToken();
			Integer.parseInt(st.nextToken());
			
			String[] S = br.readLine().split(" ");
			
			int ans = 0;
			
			for(String s : S) {
				boolean f = true;
				if( s.length() != input.length() ) continue;
				
				for( int i = 0 ; i < input.length() ; i++) {
					if ( !str[input.charAt(i) - '0'].contains(s.substring(i, i + 1)) ) {
						f = false;
						break;
					}
				}
				
				if (f) ans+=1;
				
			}
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
