package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ㅁ1로_만들기 {
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ans = Integer.MAX_VALUE;
		func(n, 0);
		
		System.out.println(ans);
	}
	public static void func(int n, int cnt) {

		if (n == 1) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (cnt >= ans) return;
		int tmp;
		if( n % 3 == 0) {
			tmp = n / 3;
			func(tmp, cnt + 1);
		}
		if (n % 2 == 0) {
			tmp = n / 2;
			func(tmp, cnt + 1);
		}
		if (n > 1){
			tmp = n - 1;
			func(tmp, cnt + 1);
		}
	}
}
