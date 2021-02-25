package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사칙연산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			
			char[] arr = new char[n+1];
			int[] left = new int[n+1];
			int[] right = new int[n+1];
			int[] arr2 = new int[n+1];
			
			String[] str;
			
			int idx = 0;
			int end = 0;
			for(int i = 1 ; i <= n ; i++) {
				str = br.readLine().split(" ");
				idx = Integer.parseInt(str[0]);
				if(str.length == 4) {
					arr[idx] = str[1].charAt(0);
					left[idx] = Integer.parseInt(str[2]);
					right[idx] = Integer.parseInt(str[3]);
					end = idx;
				}
				else arr2[idx] = Integer.parseInt(str[1]);
			}
			
			for(int i = end ; i >= 1 ; i--) {
				if(arr[i] == '+') arr2[i] = arr2[left[i]] + arr2[right[i]];
				else if(arr[i] == '-') arr2[i] = arr2[left[i]] - arr2[right[i]];
				else if(arr[i] == '*') arr2[i] = arr2[left[i]] * arr2[right[i]];
				else if(arr[i] == '/') arr2[i] = arr2[left[i]] / arr2[right[i]];
			}
			
			sb.append(arr2[1]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
