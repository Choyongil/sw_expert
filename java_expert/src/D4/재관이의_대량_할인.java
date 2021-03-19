package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 재관이의_대량_할인 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			Arrays.sort(arr);

			int idx = 0;
			int l = arr.length;
			while(idx < l) {
				if(idx % 3 == 2) {
					sum -= arr[l - idx - 1];
				}
				idx++;
			}
			sb.append(sum).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
