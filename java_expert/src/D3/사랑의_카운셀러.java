package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 사랑의_카운셀러 {
	
	static ArrayList<long[]> arr;
	static int[] numbers;
	static int[] input;
	static int n;
	static int R;
	static long ans;
	static long X;
	static long Y;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#" + tc + " ");
			X = 0;
			Y = 0;
			
			n = Integer.parseInt(br.readLine());
			arr = new ArrayList<long[]>();
			
			for(int i = 0 ; i < n ; i++) {
				long[] tmp = new long[2];
				st = new StringTokenizer(br.readLine());
				tmp[0] = Integer.parseInt(st.nextToken());
				tmp[1] = Integer.parseInt(st.nextToken());
				X += tmp[0];
				Y += tmp[1];
				arr.add(tmp);		
			}
			
			input = new int[n];
			for(int i = 0 ; i < n ; i++) {
				input[i] = i;
			}
			numbers = new int[n / 2];
			R = n / 2;
			ans = Long.MAX_VALUE;

			powerset(0, 0);
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static void powerset(int cnt, int idx) {
		
		if ( cnt == R ) {
			
			long sumx = 0;
			long sumy = 0;
			
			for(int a : numbers) {
				sumx += arr.get(a)[0];
				sumy += arr.get(a)[1];
			}
			ans = Math.min(ans, (sumx - (X - sumx))*(sumx - (X - sumx)) + (sumy - (Y - sumy)) * (sumy - (Y - sumy))); 
			
			return;
		}
		for( int i = idx ; i < n ; i++) {
			numbers[cnt] = input[i];
			powerset(cnt + 1, i + 1);
		}
		
	}
}
