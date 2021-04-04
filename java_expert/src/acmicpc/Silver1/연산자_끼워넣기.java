package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {

	static int n, ansMax, ansMin;
	static int[] arr, op;
	static boolean[] checked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];				// input 숫자
		checked = new boolean[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		op = new int[4];				// 연산자 갯수
		for(int i = 0 ; i < 4 ; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		ansMax = Integer.MIN_VALUE;
		ansMin = Integer.MAX_VALUE;
		
		go(1, arr[0]);
		
		System.out.println(ansMax + "\n" + ansMin);
	}
	
	public static void go(int idx, int sum) {
		
		if(idx == n) {
			
			ansMax = Math.max(ansMax, sum);
			ansMin = Math.min(ansMin, sum);
			return;
		}
		
		int num = arr[idx];
		// 연산 가능한 operation
		for(int j = 0 ; j < 4 ; j++) {
			if(op[j] > 0) {
				op[j]--;
				go(idx+1, operation(sum, num, j));
				op[j]++;
			}
		}
		
	}

	private static int operation(int sum, int num, int i) {
		
		switch (i) {
		
		case 0:				// 덧셈
			sum += num;
			break;
		case 1:				// 뺄셈
			sum -= num;
			break;
		case 2:				// 곱셈
			sum *= num;
			break;
		case 3:				// 나눗셈
			sum /= num;
			break;
		}
		
		return sum;
	}
}
