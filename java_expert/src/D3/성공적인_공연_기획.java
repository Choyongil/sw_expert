package D3;


import java.util.Scanner;

public class 성공적인_공연_기획 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			String s = sc.next();
			int[] arr = new int[s.length()];
			
			for (int i = 0 ; i < s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}

			int ans = 0;
			int total = arr[0];		// 일어난 사람 수
			
			for( int i = 1 ; i < arr.length ; i++) {
				if (arr[i] == 0) continue;
				if (total < i) {
					ans += i - total;
					total = i;
				}
				total += arr[i];
				
			}
			
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
