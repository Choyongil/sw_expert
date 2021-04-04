package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호_만들기 {
	
	static int n, m;
	static char[] alph;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		alph = new char[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m ; i++) {
			alph[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alph);
		
		comb(0,0,"");
		
		if(sb.length() > 0) sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static void comb(int cnt, int idx, String str) {
		
		if(cnt == n) {
			if(checking(str)) sb.append(str).append("\n");
			return;
		}
		
		for(int i = idx ; i < m ; i++) {
			comb(cnt+1, i+1, str+alph[i]);
		}
	}
	
	public static boolean checking(String str) {
		char[] vowel = {'a','e','i','o','u'};
		int v = 0;		// 모음 갯수
		int c = 0;		// 자음 갯수
		
		for(char s : str.toCharArray()) {
			boolean flag = true;
			for(char vo : vowel) {
				if(vo == s) {
					v++;
					flag = false;
					break;
				}
			}
			if(flag)
				c++;
		}

		return v >= 1 && c >=2 ? true : false;
		
	}
	
}
