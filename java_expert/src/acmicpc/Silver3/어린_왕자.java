package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 어린_왕자 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int num = Integer.parseInt(br.readLine());
			
			int ans = 0;
			
			int x,y,r;
			
			for(int i = 0 ; i < num ; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				
				double a = (Math.pow((x - x1), 2) + Math.pow((y - y1), 2));
				double b = (Math.pow((x - x2), 2) + Math.pow((y - y2), 2));
				double r2 = Math.pow(r, 2);
				if( a < r2 && b < r2) continue;
				else if( a < r2 ) ans += 1;
				else if( b < r2 ) ans += 1;
				
			}
			System.out.println(ans);
		}
	}
}
