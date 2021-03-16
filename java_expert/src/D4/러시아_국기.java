package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 러시아_국기 {
	
	static char[][] arr;
	static char[] wbr = { 'W', 'B', 'R' };
	static int[] numbers, input;
	static int n, m, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ;tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new char[n][m];
			
			for(int i = 0 ; i < n ; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			numbers = new int[4];
			input = new int[n];
			for(int i = 0 ; i < n ; i++) {
				input[i] = i;
			}
			
			numbers[0] = 0;
			ans = 987654321;
			set(1,1);
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	//부분수열
	public static void set(int cnt, int idx) {
		
		if(cnt == 3) {
			int sum = 0;
			numbers[3] = n;
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = numbers[i] ; j < numbers[i+1] ; j++) {
					for(int k = 0 ; k < m ; k++) { 
						if (arr[j][k] != wbr[i]) {
							sum += 1;
						}
					}
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i = idx ; i < n ; i++) {
			numbers[cnt] = input[i];
			set(cnt + 1, i + 1);
		}
		
		return;
	}
}
