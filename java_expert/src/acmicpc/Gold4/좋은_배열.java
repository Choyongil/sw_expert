package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은_배열 {

	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			System.out.println(1);
		} else {
			
			search("");
		}
	}
	
	public static void search(String num) {

		if(num.length() == n) {
			System.out.println(num);
			System.exit(0);
		}
		
		
		for(int i = 1 ; i < 4 ; i++) {
			
			if(!check(num + i)) continue;
			
			search(num + i);
		}
	}
	
	public static boolean check(String num) {

		int len = 1;
		while(len <= num.length() / 2) {
			
			for(int i = 0 ; i < num.length() ; i++) {
				if(i + len * 2 > num.length()) continue;
				
				if(num.substring(i, i + len).equals(num.substring(i + len, i + len * 2))) {
					return false;
				}
			}
			
			len++;
		}
		
		return true;
	}
}
