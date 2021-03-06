package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
	static int n;
	static boolean[] visited;
	static int[] input, numbers;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			input = new int[n];
			
			for(int i = 0 ; i < n ; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[n];
			numbers = new int[6];
			go(0, 0);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 2);
		System.out.println(sb);
	}

	public static void go(int cnt, int idx) {
		
		if ( cnt == 6 ) {
			
			for(int i = 0 ; i < 6 ; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
			return;
		}
		
		if ( idx == n ) return;

		numbers[cnt] = input[idx];
		go(cnt + 1, idx + 1);
		go(cnt, idx + 1);
	}
}
