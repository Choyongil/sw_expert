package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;


public class 새로운_불면증_치료법 {
	 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for ( int i = 1; i <= T; i++) {
			String s = br.readLine();
			int n = Integer.parseInt(s);
			
			int[] check = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
			int j = 0;
			int cnt = 1;
			
			while (true) {
				for (int idx = 0; idx < s.length(); idx++) {
					int tmp = Integer.parseInt(s.substring(idx,idx+1));
					if ( !IntStream.of(check).anyMatch(x -> x == tmp) ) {
						check[j] = tmp;
						j++;
					}
				}
				if (j == 10) {
					break;
				}
				cnt++;
				s = Integer.toString(n * cnt);
			}
			System.out.println("#" + i + " " + cnt * n);
		}
		
	}
}
