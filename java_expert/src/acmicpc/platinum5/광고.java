package acmicpc.platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 광고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String p = br.readLine();
		
		int[] pi = new int[p.length()];
		
		// make pi
		int j = 0;
		for(int i = 1 ; i < p.length() ; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) j = pi[j-1];
			if(p.charAt(i) == p.charAt(j)) pi[i] = ++j;
		}
		System.out.println(Arrays.toString(pi));
		System.out.println(n - pi[n-1]);
		
	}
}
