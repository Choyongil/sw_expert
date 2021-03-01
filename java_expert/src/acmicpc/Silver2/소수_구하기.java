package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 소수_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		
		ArrayList<Boolean> prime = new ArrayList<Boolean>(max+1);
		prime.add(false);
		prime.add(false);
		for(int i = 2 ; i <= max ; i++) {
			prime.add(i,true);
		}
		
		for(int i = 2 ; i*i <= max ; i++) {
			if(prime.get(i)) {
				for(int j = i * i ; j <= max ; j += i) {
					prime.set(j, false);
				}
			}
		}
		
		for(int i = min ; i <= max ; i++) {
			if(prime.get(i)) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
