package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {

	static int n, ans;
	static boolean[] alpha;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ans = 0;
		
		// 가르쳐야 하는 단어는 무조건 5개 이상이어야 한다. a, n, t, i, c
		if(m < 5) ans = 0;
		else {
			alpha = new boolean[26];
			alpha[0] = true;
			alpha['n' - 'a'] = true;
			alpha['t' - 'a'] = true;
			alpha['i' - 'a'] = true;
			alpha['c' - 'a'] = true;
			
			str = new String[n];
			for(int i = 0 ; i < n ; i++) {
				str[i] = br.readLine();
			}
			
			chooseAlpha(0, m - 5);
			
		}
		System.out.println(ans);
	}
	
	public static void chooseAlpha(int idx, int cnt) {
		
		if(cnt == 0) {
			int sum = check();
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i = idx ; i < 26 ; i++) {
			if(alpha[i]) continue;
			alpha[i] = true;
			chooseAlpha(i + 1, cnt - 1);
			alpha[i] = false;
		}
	}
	
	public static int check() {
		int sum = 0;
		boolean flag;
		for(String s : str) {
			flag = true;
			
			for(int i = 0 ; i < s.length() ; i++) {
				if(!alpha[s.charAt(i) - 'a']) {
					flag = false;
					break;
				}
			}
			
			// alpha 배열로 해당 단어를 읽을 수 있으면 sum++
			if(flag) sum++;
		}
		
		return sum;
		
	}
}
