package acmicpc.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String T = br.readLine();
		String p = br.readLine();
		
		int[] pi = new int[p.length()];
		int ans = 0;
		
		// make pi
		int j = 0;
		for(int i = 1 ; i < p.length() ; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) j = pi[j-1];
			if(p.charAt(i) == p.charAt(j)) pi[i] = ++j;
		}

		// do KMP
		j = 0;
		for(int i = 0 ; i < T.length() ; i++) {
			while(j > 0 && T.charAt(i) != p.charAt(j)) j = pi[j-1];
			if(T.charAt(i) == p.charAt(j)) j++;
			if(j == p.length()) {
				ans++;
				sb.append(i-j+2).append(" ");
				j = pi[j-1];
			}
		}
		
		System.out.println(ans);
		System.out.println(sb);	
	}
}

/*
ABC ABCDAB ABCDABCDABDE
aabaaa
ababaca
*/


/*

== make pi ==
int j = 0;
for(int i = 1; i < pn; i++){
    while(j > 0 && p[i] != p[j]) j = pi[j-1]; 
    if(p[i] == p[j]) pi[i] = ++j; 
}

== do KMP == 
int j = 0;
for(int i = 0; i < tn; i++){
    while(t[i] != p[j] && j > 0)j = pi[j - 1];
    if(t[i] == p[j])j++;
    if(j == pn - 1)ans[an++] = i - pn + 3;
}
*/