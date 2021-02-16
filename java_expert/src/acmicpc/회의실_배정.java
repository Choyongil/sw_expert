package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실_배정 {
	
	public static void main(String[] args) throws IOException {
		
		class time implements Comparable<time>{
			int start;
			int end;
			
			public time(int start, int end) {
				this.start = start;
				this.end = end;
			}
			
			@Override
			public int compareTo(time o) {
				if(this.end == o.end) return this.start - o.start;
				return this.end - o.end;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<time> T = new ArrayList<time>();
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time t = new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			T.add(t);
		}
		
		Collections.sort(T);
		int end = 0;

		int ans = 0;
		for(int i = 0 ; i < n ; i++) {
			if( end <= T.get(i).start) {
				end = T.get(i).end;
				ans += 1;
			}
		}
		
		System.out.println(ans);
	}
	
}
