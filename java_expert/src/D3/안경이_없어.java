package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안경이_없어 {
	
	static String str1 = "CEFGHIJKLMNSTUVWXYZ";
	static String str2 = "ADOPQR";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc +  " ");
			
			st = new StringTokenizer(br.readLine(), " ");
					
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			if(s1.length() != s2.length()) {
				sb.append("DIFF");
			}
			else {
				boolean f = true;
				for(int i = 0 ; i < s1.length() ; i++) {
					if( ( str1.contains(s1.substring(i, i+1)) && str1.contains(s2.substring(i, i+1))) || 
							( str2.contains(s1.substring(i, i+1)) && str2.contains(s2.substring(i, i+1))) ||
							( s1.charAt(i) == 'B' && s2.charAt(i) == 'B')) {
						continue;
					}
					else {
						f = false;
						break;
					}
				}
				sb.append(f ? "SAME" : "DIFF");
			}
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
