package acmicpc.Silver1;

import java.util.Arrays;
import java.util.Scanner;

// dp
public class ㅁ1로_만들기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		int[] arr = new int[n + 1];
		int[] step = new int[n + 1];
		
		for(int i = 2; i <= n ; i++) {
			int x = i % 2 == 0 ? (i / 2 == 1 ? 1 : arr[i / 2] + 1) : 98765321;
			int y = i % 3 == 0 ? (i / 3 == 1 ? 1 : arr[i / 3] + 1) : 98765321;
			int z = i - 1 == 1 ? 1 : (arr[i - 1] + 1);
			arr[i] = Math.min(x, Math.min(y, z));
			int min = x > y ? i / 3 : i / 2;
			min = Math.min(x, y) > z ? i - 1 : min;
			step[i] = min;
		}
		int idx = n;
		sb.append(arr[n]).append("\n");
		System.out.println(Arrays.toString(step));
		while(idx != 0) {
			
			sb.append(idx).append(" ");
			idx = step[idx];
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		sc.close();
	}
}
