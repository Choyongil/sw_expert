package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		
		int sum = 0, ans = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == '(') sum += 1;
			else {
				sum--;
				if(arr[i - 1] == '(') {
					ans += sum;
				}
				else {
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
