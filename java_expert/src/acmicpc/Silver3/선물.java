package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선물 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		double n = Double.parseDouble(st.nextToken());
		double l = Double.parseDouble(st.nextToken());
		double w = Double.parseDouble(st.nextToken());
		double h = Double.parseDouble(st.nextToken());
		
		double low = 0;
		double high = Math.max(Math.max(l, w),h);
		double mid = 0;
		long a = 0;
		long b = 0;
		long c = 0;

		for( int i = 0 ; i < 10000 ; i++) {

			mid = (low + high) / 2;
			a = (long) (((long) l) / mid);
			b = (long) (((long) w) / mid);
			c = (long) (((long) h) / mid);
			if( a * b * c >= n ) {
				low = mid;
			}
			else {
				high = mid;
			}
		}
		System.out.println(high);
		
	}
	
}
