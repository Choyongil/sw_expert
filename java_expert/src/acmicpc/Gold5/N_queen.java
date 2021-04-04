package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_queen {

	static int n, ans;
	static int[] col;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = 0;
		
		col = new int[n+1];
		
		setQueen(1);
		
		System.out.println(ans);
	}

	private static void setQueen(int cnt) {
		if( cnt > n ) {
			ans++;
			return;
		}
		
		for(int i = 1 ; i <= n ; i++) {
			col[cnt] = i;
			if(check(cnt)) {
				setQueen(cnt+1);
			}
		}
	}

	private static boolean check(int cnt) {
		
		for(int i = 1 ; i < cnt ; i++) {
			if(col[cnt] == col[i] || Math.abs(i - cnt) == Math.abs(col[cnt] - col[i])) return false;
		}
		
		return true;
	}
}
