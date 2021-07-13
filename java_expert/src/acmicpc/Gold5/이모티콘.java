package acmicpc.Gold5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 이모티콘 {

	static class Point{
		int x, cnt, clip;

		public Point(int x, int cnt, int clip) {
			super();
			this.x = x;
			this.cnt = cnt;
			this.clip = clip;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		Queue<Point> queue = new LinkedList<>();
		boolean[] visited = new boolean[2000];
		queue.add(new Point(1, 1, 1));
		
		int ans = 0;
		if(s == 1) {
			ans = 0;
		} else {
		
			while(!queue.isEmpty()) {
				Point q = queue.poll();
				if(q.x == s) {
					ans = q.cnt;
					break;
				}
				
				// 클립보드에 복사
				if(q.x != q.clip) queue.add(new Point(q.x, q.cnt + 1, q.x));
				
				// 클립보드에 있는 이모티콘 붙여넣기
				if(q.x + q.clip <= 1500) {
					queue.add(new Point(q.x + q.clip, q.cnt + 1, q.clip));
					visited[q.x + q.clip] = true;
				}
				
				// 하나 삭제
				if(q.x - 1 > 1 && !visited[q.x - 1]) {
					queue.add(new Point(q.x - 1, q.cnt + 1, q.clip));
					visited[q.x - 1] = true;
				}
			}
		}
		
		System.out.println(ans);
	}
}
