package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

	static class Point{
		int x;
		int idx;
		public Point(int x, int idx) {
			super();
			this.x = x;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Point> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		int x = -1;
		for(int i = 0 ; i < n ; i++) {
			x = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.add(new Point(x, i));
			} else {
				while(!stack.isEmpty()) {

					Point s = stack.pop();
					if(s.x >= x) {
						stack.add(s);
						stack.add(new Point(x, i));
						sb.append(s.idx + 1).append(" ");
						break;
					}
				}
				
				if(stack.isEmpty()) {
					stack.add(new Point(x,i));
					sb.append(0).append(" ");
				}
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}