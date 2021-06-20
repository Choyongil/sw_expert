package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 스타트링크 {

	static int F, S, G, U, D;
	static boolean[] visited;
	static class point{
		int cnt;
		int floor;
		public point(int cnt, int floor) {
			super();
			this.cnt = cnt;
			this.floor = floor;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1];
		visited[S] = true;
		int ans = 987654321;
		if(S != G) {
		
			PriorityQueue<point> pq = new PriorityQueue<>((o1, o2) -> (o1.cnt - o2.cnt));
			pq.add(new point(0, S));
			
			while(!pq.isEmpty()) {
				point q = pq.poll();
				
				if(q.floor == G) {
					ans = q.cnt;
					break;
				}
				
				// up
				int newF = q.floor + U;
				if(newF <= F && !visited[newF]) {
					visited[newF] = true;
					pq.add(new point(q.cnt + 1, newF));
				}
				
				// down
				newF = q.floor - D;
				if(newF >= 1 && !visited[newF]) {
					visited[newF] = true;
					pq.add(new point(q.cnt + 1, newF));
				}
			}
		} else ans = 0;
		
		System.out.println(ans == 987654321 ? "use the stairs" : ans);
	}
}
