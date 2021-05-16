package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이_0이_네_정수 {

	static int n, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[4][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 4 ; j++) {
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		int[] ab = new int[n*n];
		int[] cd = new int[n*n];
		int idx1 = 0;
		int idx2 = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				ab[idx1++] = map[0][i] + map[1][j];
				cd[idx2++] = map[2][i] + map[3][j];
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		long cnt = 0;
		idx1 = 0;
		idx2 = n*n - 1;
		while(idx1 < n*n && idx2 >= 0) {
			int x = ab[idx1];
			int y = cd[idx2];
			long cnt1 = 0;
			long cnt2 = 0;
			if(x + y == 0) {
				while(idx1 < n*n && ab[idx1] == x) {
					cnt1++;
					idx1++;
				}
				while(idx2 >= 0 && cd[idx2] == y) {
					cnt2++;
					idx2--;
				}
				cnt += cnt1 * cnt2;
			} else if(x+y > 0) {
				idx2--;
			} else {
				idx1++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
