package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼성시의_버스_노선 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			int[] arr = new int[5000];
			
			int n = Integer.parseInt(br.readLine());
			int a, b;
			
			for(int i = 0 ; i < n ;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				for(int j = a - 1 ; j <= b - 1 ; j++) {
					arr[j] += 1;
				}
			}
			int P = Integer.parseInt(br.readLine());
			
			for(int i = 0 ; i < P ; i++) {
				sb.append(arr[Integer.parseInt(br.readLine()) - 1] + " ");
			}
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
