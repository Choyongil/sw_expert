package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 중간값_찾기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		
		int a = Integer.parseInt(br.readLine());
		int[] arr = new int[a];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < a; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		int sum = 0;
		int idx = 0;
		while(true) {
			sum += arr[idx++];
			if (sum >= a / 2) break;
		}
		
		System.out.println(idx);
		
	}
}
