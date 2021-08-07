package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		// arr 의 총합을 구할 변수 tmp 가 s 보다 작아버리면 무조건 0 이다.
		int tmp = 0;
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp += arr[i];
		}

		int ans = 0;
		
		if(tmp == s) ans = arr.length;
		else if( tmp > s ) {
		
			int start_idx = 0;
			int end_idx = 0;
			int len = 1;
			
			int sum = arr[start_idx];
			out: while(true) {
				
	//			System.out.println("start : " + start_idx + ", end_idx : " + end_idx + ", sum : " + sum + ", len : " + len);
				
				if(start_idx == end_idx) {
					// start_idx 와 end_idx 가 같을 때
					len = 1;
					
					if(sum >= s) {
						// 합(sum)이 s 보다 크거나 같면 ans = 1 이 되고 break
						ans = 1;
						break out;
					} else {
						// 합이 s 보다 작을 때
						
						if(end_idx == arr.length - 1) {
							// end_idx 가 arr 끝에 있을 때
							break out;
						} else {						
							// 길이(len) 을 1 더하고 다음 반복문으로
							end_idx++;
							len++;
							sum += arr[end_idx];
						}
					}
					
				} else {
					// start_idx 와 end_idx 가 다를 때
					
					if(sum >= s) {
						// 합이 s 보다 크거나 같으면 ans 값 최신화하고 합에서 start_idx 의 값을 빼주고 1 증가, len 1 감소
						if(ans == 0) {
							ans = len;
						} else {
							ans = Math.min(ans, len);
						}
						sum -= arr[start_idx];
						len--;
						start_idx++;
					} else {
						// 합이 s 보다 작을 때
						
						// end_idx 가 arr 의 끝에 있을 때 더이상 ans 보다 적은 값이 나올 수가 없다.
						if(end_idx == arr.length - 1) {
							break out;
						} else {
							// end_idx 증가 및 sum 에 end_idx 값 더하기, len 1 증가
							end_idx++;
							sum += arr[end_idx];
							len++;
						}
					}
					
				}
			}
			
		}
		
		System.out.println(ans);
	}
}
