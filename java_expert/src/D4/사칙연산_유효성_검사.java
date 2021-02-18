package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사칙연산_유효성_검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			
			int n = Integer.parseInt(br.readLine());
			
			boolean flag = true;
			for(int i = 0 ; i < n ; i++) {
				String[] str = br.readLine().split(" ");
				if (str.length == 4) {
					char c = str[1].charAt(0);
					if ( c == '+' || c == '-' || c == '*' || c == '/' ) {
						continue;
					}
					else {
						flag = false;
					}
				}
			}
			sb.append(flag ? 1 : 0);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
