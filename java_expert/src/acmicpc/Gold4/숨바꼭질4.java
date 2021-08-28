package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class 숨바꼭질4 {

	static int n, m, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n == m) sb.append(0).append("\n").append(n);
		else {
			boolean[] visited = new boolean[100001];
			int[] nextIdx = new int[100001];
			Arrays.fill(nextIdx, -1);
			
			Queue<Integer> queue = new LinkedList<>();
			Stack<Integer> stack = new Stack<>();
			
			visited[n] = true;
			queue.add(n);
			
			while(!queue.isEmpty()) {
				int q = queue.poll();

				if(q == m) {
					break;
				}
				
				if(q + 1 <= 100000 && !visited[q + 1]) {
					visited[q + 1] = true;
					nextIdx[q + 1] = q;
					queue.add(q + 1);
				}

				if(q - 1 >= 0 && !visited[q - 1]) {
					visited[q - 1] = true;
					nextIdx[q - 1] = q;
					queue.add(q - 1);
				}
				
				if(q * 2 <= 100000 && !visited[q * 2]) {
					visited[q * 2] = true;
					nextIdx[q * 2] = q;
					queue.add(q * 2);
				}
			}

			int idx = m;
			ans = 0;
			while(idx != n) {
				stack.push(idx);
				ans++;
				idx = nextIdx[idx];
			}

			sb.append(ans).append("\n");
			sb.append(n).append(" ");
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			sb.setLength(sb.length() - 1);
		}
		System.out.println(sb);
	}
}
