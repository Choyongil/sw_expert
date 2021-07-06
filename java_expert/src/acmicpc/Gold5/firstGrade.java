package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class firstGrade {

	static int n, num[];
	static long cnt[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		cnt = new long[21][n - 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) num[i] = Integer.parseInt(st.nextToken());
		
		cnt[num[0]][0] = 1;
		
		for(int i = 1 ; i < n - 1; i++) {
			for(int j = 0 ; j < 21 ; j++) {
				if(cnt[j][i - 1] > 0) {
					
					// 뺄셈
					if(j - num[i] >= 0) {
						cnt[j - num[i]][i] += cnt[j][i - 1];
					}
					
					// 덧셈
					if(j + num[i] <= 20) {
						cnt[j + num[i]][i] += cnt[j][i - 1];
					}
				}
			}
		}
		System.out.println(cnt[num[n-1]][n-2]);
	}
}
