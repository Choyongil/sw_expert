package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ㅁ123더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] ans = new int[10];
		ans[0] = 1;
		ans[1] = 2;
		ans[2] = 4;
		
		for(int i = 3; i < 10 ; i++) {
			ans[i] = ans[i-1] + ans[i-2] + ans[i-3];
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(ans[Integer.parseInt(br.readLine()) - 1]);
		}
	}
}
