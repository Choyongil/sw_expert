package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class 오큰수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		// input data 저장할 배열
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// index 저장할 stack
		Stack<Integer> stack = new Stack<>();
		
		stack.add(0);
		
		for(int i = 1 ; i < n ; i++) {
			
			// stack.peek 보다 작으면 stack 에 index 추가
			if(arr[stack.peek()] >= arr[i]) {
				stack.add(i);
			} else {
				
				// stack 사이즈가 0이 아니고 peek 보다 크다면 그 인덱스에 위치한 값을 -1 로 변경해주기
				while(stack.size() != 0 && arr[stack.peek()] < arr[i]) {
					arr[stack.pop()] = arr[i];
				}
				stack.add(i);
			}
		}
		
		for(int x : stack) arr[x] = -1;
		
		
		for(int x : arr) {
			sb.append(x).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
