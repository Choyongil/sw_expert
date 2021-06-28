package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {

	static int n, m;
	static class Num{
		int x;
		String str;
		public Num(int x, String str) {
			super();
			this.x = x;
			this.str = str;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			boolean[] visited = new boolean[10000];
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			visited[n] = true;
			Queue<Num> queue = new LinkedList<>();
			queue.add(new Num(n,""));
			
			while(!queue.isEmpty()) {
				
				Num q = queue.poll();
				
				if(q.x == m) {
					sb.append(q.str).append("\n");
					break;
				}
				
				int newN = 0;
				
				// D
				newN = (q.x * 2) % 10000;
				if(!visited[newN]) {
					queue.add(new Num(newN, q.str + "D"));
					visited[newN] = true;
				}
				
				// S
				newN = q.x - 1 == -1 ? 9999 : q.x - 1;
				if(!visited[newN]) {
					queue.add(new Num(newN, q.str + "S"));
					visited[newN] = true;
				}
				
				String s = Integer.toString(q.x);
				while(s.length() != 4) {
					s = "0" + s;
				}
				
				// L
				newN = (((s.charAt(1) - '0') * 10 + (s.charAt(2) - '0')) * 10 + (s.charAt(3) - '0')) * 10 + (s.charAt(0) - '0');
				if(!visited[newN]) {
					queue.add(new Num(newN, q.str + "L"));
					visited[newN] = true;
				}
				
				// R
				newN = (((s.charAt(3) - '0') * 10 + (s.charAt(0) - '0')) * 10 + (s.charAt(1) - '0')) * 10 + (s.charAt(2) - '0');
				if(!visited[newN]) {
					queue.add(new Num(newN, q.str + "R"));
					visited[newN] = true;
				}
			}
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
