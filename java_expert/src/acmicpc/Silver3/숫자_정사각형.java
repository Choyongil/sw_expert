package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 숫자_정사각형 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r;
	static int c;
	static int[][] arr;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			arr[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		ans = 1;
		
		for(int i = 0 ; i < r - 1 ; i++) {
			for(int j = 0 ; j < c - 1 ; j++) {
				System.out.println("i : " + i + " j : " + j);
				func(i,j,i+1,j+1);
			}
		}
		
		System.out.println(ans);
	}
	
	public static void func(int sr, int sc, int cr, int cc) {
		
		if((cr == r) || (cc == c)) return;
		
		if(arr[sr][sc] == arr[sr][cc] && arr[sr][sc] == arr[cr][sc] && arr[sr][sc] == arr[cr][cc]) {
			if (ans < (cc - sc + 1) * (cr - sr + 1)) {
				ans = (cc - sc + 1) * (cr - sr + 1);
			}
		}
		func(sr, sc, cr + 1, cc + 1);
	}
}
