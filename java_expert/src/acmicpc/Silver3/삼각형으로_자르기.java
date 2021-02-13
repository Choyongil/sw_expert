package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각형으로_자르기 {

	static int[] arr_x;
	static int[] arr_y;
	static int[] numbers;
	static int[] input;
	static int n;
	static double ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr_x = new int[n];
		arr_y = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr_x[i] = Integer.parseInt(st.nextToken());
			arr_y[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		numbers = new int[3];
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = i;
		}
		func(0,0);
		
		System.out.println(ans);
	}
	
	public static Double S(int x1, int y1, int x2, int y2, int x3, int y3) {
		
		double d = x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3;
		return Math.abs(d / 2);
	}
	
	public static void func(int cnt, int idx) {
		
		if( cnt == 3 ) {
			ans = Math.max(ans, S(arr_x[numbers[0]], arr_y[numbers[0]], arr_x[numbers[1]], arr_y[numbers[1]], arr_x[numbers[2]], arr_y[numbers[2]]));
			return;
		}
		
		for(int i = idx ; i < n ; i++) {
			numbers[cnt] = input[i];
			func(cnt + 1, i + 1);
		}
	}
}
