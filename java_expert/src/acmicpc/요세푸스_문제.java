package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i <= n ; i++) {
			queue.offer(i);
		}

		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 0 ; i < k - 1 ; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
