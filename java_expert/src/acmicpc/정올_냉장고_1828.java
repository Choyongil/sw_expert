package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 정올_냉장고_1828 {
	public static void main(String[] args) throws IOException {
		
		class temp implements Comparable<temp>{
			int low;
			int high;
			
			public temp(int low, int high) {
				this.low = low;
				this.high = high;
			}
			
			@Override
			public int compareTo(temp o) {
				if(this.high == o.high) return this.low - o.low;
				return this.high - o.high;
			}

			@Override
			public String toString() {
				return "time [low=" + low + ", high=" + high + "]";
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<temp> T = new ArrayList<temp>();
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			temp t = new temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			T.add(t);
		}
		
		Collections.sort(T);
		int high = T.get(0).high;
		
		int ans = 1;
		for(int i = 1 ; i < n ; i++) {
			if( high < T.get(i).low) {
				high = T.get(i).high;
				ans += 1;
			}
		}
		
		System.out.println(ans);
	}
}
