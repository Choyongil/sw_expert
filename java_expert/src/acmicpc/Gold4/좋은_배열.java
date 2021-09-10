package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은_배열 {

	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			System.out.println(1);
		} else {
			search("");
		}
	}
	
	public static void search(String num) {

		if(num.length() == n) {
			// 조건에 해당하는 num을 찾으면 출력하고 process 종료
			System.out.println(num);
			System.exit(0);
		}
		
		
		// 1,2,3만 num에 더하기
		for(int i = 1 ; i < 4 ; i++) {
			
			// check함수를 통해 나쁜수열인지 확인한다.(나쁜수열이면 false)
			if(!check(num + i)) continue;
			
			search(num + i);
		}
	}
	
	public static boolean check(String num) {

		// 검사할 문자열 길이
		int len = 1;
		// 검사할 문자열의 최대 길이는 num의 절반
		while(len <= num.length() / 2) {
			
			for(int i = 0 ; i < num.length() ; i++) {
				
				// 검사하고자 하는 길이가 num을 초과하면 다음 조건으로 검색
				if(i + len * 2 > num.length()) continue;
				
				// substring으로 자른 두 문자열을 비교
				if(num.substring(i, i + len).equals(num.substring(i + len, i + len * 2))) {
					return false;
				}
			}
			
			// 검사할 len(길이) 1 증가
			len++;
		}
		
		return true;
	}
}
