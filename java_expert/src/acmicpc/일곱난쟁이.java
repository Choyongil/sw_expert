package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] isSelected = new boolean[9];
	static int[] arr;
	static int sum = 0;
	static int cnt = 0;
	static int[] ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		arr = new int[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		func(0);
	}
	
public static void func(int idx) {
	
		if(idx == 9) {
			sum = 0;
			ans = new int[7];
			cnt = 0;
			
			try {
				for(int i = 0 ; i < 9 ; i++) {
					if(isSelected[i]) {
						ans[cnt] = arr[i];
						sum += arr[i];
						cnt += 1;
					}
				}
			}
			catch(Exception e) {
				return;
			}
			if (sum == 100 && cnt == 7) {
				Arrays.sort(ans);
				for(int a : ans) System.out.println(a);
				System.exit(0);
			}
			return;
		}
		
		isSelected[idx] = true;
		func(idx+1);
		isSelected[idx] = false;
		func(idx+1);
	}
}
