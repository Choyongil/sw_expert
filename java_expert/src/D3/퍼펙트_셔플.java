package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퍼펙트_셔플 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			
			sb.append("#" + tc + " ");
			
			int n = Integer.parseInt(br.readLine());
			
			String[] arr = new String[n];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < n ; i++) {
				arr[i] = st.nextToken();
			}
			
			int idx = n % 2 == 0 ? n / 2 : n / 2 + 1;
			
			for(int i = 0 ; i < idx - 1 ; i++){
				sb.append(arr[i] + " " + arr[i + idx] + " ");
			}
			if (n % 2 == 0) {
				sb.append(arr[idx - 1] + " " + arr[n - 1]);
			} else {
				sb.append(arr[idx - 1]);
			}
			
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
