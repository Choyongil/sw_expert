package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 민석이의_과제체크 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			for(int i = 0 ; i < n ; i++) {
				arr[i] = i + 1;
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < k ; i++) {
				arr[Integer.parseInt(st.nextToken()) - 1] = -1;
			}
			
			for(int x : arr) {
				if (x > 0) sb.append(x + " ");
			}
			
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
