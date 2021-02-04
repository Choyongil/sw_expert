package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형과_점 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[3];
			
			int N = Integer.parseInt(br.readLine());
			int x, y;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				if(x < x1 || x > x2 || y < y1 || y > y2) arr[2]++;
				else if(x == x1 || x == x2 || y == y1 || y == y2) arr[1]++;
				else arr[0]++;
			}
			for(int a : arr) {
				sb.append(a + " ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
