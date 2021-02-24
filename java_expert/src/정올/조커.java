package 정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 조커 {

	static int joker, n, ans;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = 0;
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				joker += 1;
			}
		}
		
		Arrays.sort(arr);
		
		for(int i = 0 ; i < n; i++) {
			if(arr[i] == 0) continue;
			func(i, 1, joker);
		}
		
		System.out.println(joker == n ? joker : ans);
	}
	
	public static void func(int curIdx, int cnt, int x) {
		if( curIdx == n - 1) {
			ans = Math.max(cnt + x, ans);
		}
		else if(arr[curIdx+1] == arr[curIdx] ) {
			func(curIdx + 1, cnt, x);
		}
		else if(arr[curIdx+1] == arr[curIdx] + 1 ) {
			func(curIdx + 1, cnt + 1, x);
		}
		else if( x != 0 && arr[curIdx+1] - arr[curIdx] - 1 <= x ) {
			func(curIdx + 1, cnt + (arr[curIdx+1] - arr[curIdx]), x - (arr[curIdx+1] - arr[curIdx] - 1));
		}
		else if( arr[curIdx+1] != arr[curIdx] + 1) {
			ans = Math.max(cnt + x, ans);
		}
	}
}
//7
//0 6 5 10 3 0 11