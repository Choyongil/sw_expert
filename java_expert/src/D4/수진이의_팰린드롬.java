package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수진이의_팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			char[] arr = br.readLine().toCharArray();
			
			int[] num = new int[26];
			for(char c : arr) {
				num[c-'a']++;
			}
			
			int sum = 0;
			for(int i : num) {
				if(i == 0) continue;
				else {
					sum += i*(i+1)/2;
				}
			}
			
			sb.append(sum).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
