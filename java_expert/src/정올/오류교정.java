package 정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오류교정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		int check = 0; // 짝수인지 확인
		int r = 0;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
			if (sum % 2 != 0) {
				r = i;
				check += 1;
			}
		}
		
		if(check > 1) {
			System.out.println("Corrupt");
			return;
		}
		else {
			check = 0;
			int c = 0;
			for(int i = 0 ; i < n ; i++) {
				int sum = 0;
				for(int j = 0 ; j < n ; j++) {
					sum += arr[j][i];
				}
				if (sum % 2 != 0) {
					c = i;
					check += 1;
				}
			}
			if( check > 1 ) {
				System.out.println("Corrupt");
				return;
			}
			else if(check == 1) {
				System.out.println("Change bit (" + (r+1) + "," + (1+c) + ")");
			}
			else System.out.println("OK");
		}
		
		
	}
}
