package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단어_수학 {

	static int n, arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		// 'A', 'B', 'C' ... 'Z'
		// 알파벳이 나온 값을 저장
		List<int[]> list = new ArrayList<>();
		for(int i = 0 ; i < 26 ; i++) {
			list.add(new int[] {i, 0});
		}
		
		String input;	
		int idx;		// 자릿수 (Math.pow 2번째 값)
		for(int i = 0 ; i < n ; i++) {
			input = br.readLine();
			idx = 0;
			for(int j = input.length() - 1 ; j >= 0 ; j--) {
				// 끝에 자리 수 부터 1, 10, 100... 만큼 곱한 값을 list 에 저장(추가)
				list.get(input.charAt(j) - 'A')[1] += (int) Math.pow(10, idx++);
			}
		}
		
		// 값이 제일 큰 수가 앞으로 오도록 정렬
		Collections.sort(list, ((o1, o2) -> o2[1] - o1[1]));

		int ans = 0;
		// 가장 큰 값을 가지는 알파벳부터 9, 8, 7... 곱해주기
		int num = 9;
		for(int i = 0 ; i < 26 ; i++) {
			if(list.get(i)[1] == 0) break;
			ans += list.get(i)[1] * num--;
		}
		System.out.println(ans);
	}
}
