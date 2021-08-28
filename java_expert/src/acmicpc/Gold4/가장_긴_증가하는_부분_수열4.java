package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];

		for(int i = 0 ; i < n ; i++) {
			arr[i + 1] = Integer.parseInt(st.nextToken());
		}
		
		if(n == 1) {
			System.out.println(1 + "\n" + arr[1]);
		} else {
			
			int[] cnt = new int[n + 1];		// 현재 index 에서 가장 긴 증가하는 부분 수열 길이를 저장하는 배열
			int[] idx = new int[n + 1];		// 가장 긴 증가하는 부분수열을 만들기 위한 바로 전 index 값을 저장하는 배열
			int ans = 1;					// 가장 긴 증가하는 부분수열 길이
			int index = 1;					// 가장 긴 경우의 마지막 index 값
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 0 ; j < i ; j++) {
					if(arr[j] < arr[i] && cnt[j] + 1 > cnt[i]) {
						cnt[i] = cnt[j] + 1;
						idx[i] = j;
					}
				}
				
				if(ans < cnt[i]) {
					ans = cnt[i];
					index = i;
				}
			}
			
			sb.append(ans).append("\n");
	
			// 가장 긴 증가하는 부분수열을 넣어줄 array
			int[] newArr = new int[ans];
			int newIdx = ans - 1;

			while(index != 0) {
				
				// 가장 긴 증가하는 부분수열을 구성하는 바로 전 값의 index를 추적해서 newArr에 넣어준다.
				newArr[newIdx--] = arr[index];
				
				// index 값을 최신화
				index = idx[index];
			}
			
			for(int x : newArr) sb.append(x).append(" ");
			
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		}
	}
}
//반례찾기
//7
//1 6 2 4 5 3 7
//6
//1 3 5 7 2 3