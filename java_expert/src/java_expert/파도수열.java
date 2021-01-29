package java_expert;

import java.util.Scanner;

public class 파도수열 {
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		StringBuilder sb = new StringBuilder("");
		
		long[] arr = new long[100];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		for(int i = 3 ; i < 100 ; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			sb.append("#" + tc + " ");
			long ans = arr[N-1];
			
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
		sc.close();
	}
}





