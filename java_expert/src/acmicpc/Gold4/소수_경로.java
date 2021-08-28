package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소수_경로 {

	static int a, b, ans;
	static List<Boolean> prime;
	static class Point {
		int num, cnt;

		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 에라토스테네스의 체를 이용해서 4자리의 소수들을 구한다.
		prime = new ArrayList<>();
		prime.add(false);
		prime.add(false);
		for(int i = 2 ; i < 10000 ; i++) {
			prime.add(true);
		}
		for(int i = 2 ; i * i < 10000 ; i++) {
			if(prime.get(i)) {
				for(int j = i ; j < 10000 ; j += i) {
					prime.set(j, false);
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = 987654321;
			
			// a와 b가 같으면 0
			if(a == b) ans = 0;
			else bfs();
			
			// 똑같은 수 b를 못 찾으면 ans 값은 변함없이 987654321이므로 Impossible
			if(ans == 987654321) sb.append("Impossible");
			else sb.append(ans);
			
			sb.append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		
	}
	
	public static void bfs() {
		
		// 한번 방문한 숫자인지 판별할 boolean 배열
		boolean[] visited = new boolean[10000];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(a, 0));
		visited[a] = true;
		
		while(!queue.isEmpty()) {
			Point que = queue.poll();
			int q = que.num;
			
			if(q == b) {
				ans = que.cnt;
				break;
			}
			
			// 한 자리만 바꾼 다음 그 숫자가 처음 접근하는 소수이면 큐에 추가
			// 0 ~ 9 까지의 숫자를 대입
			int tmp;
			for(int i = 0 ; i < 10 ; i++) {
				// 4자리를 비교
				for(int j = 0 ; j < 4 ; j++) {
					// 첫번째 자리를 0으로 둘 순 없으므로 continue
					if(j == 3 && i == 0) continue;
					
					if(j == 0) {
						// 1의 자릿수 변경
						tmp = q - q % 10 + i;
					} else if(j == 1) {
						// 10의 자릿수 변경
						tmp = q - q % 100 + q % 10 + i * 10;
					} else if(j == 2) {
						// 100의 자릿수 변경
						tmp = q - q % 1000 + q % 100 + i * 100;
					} else {
						// 1000의 자릿수 변경
						tmp = q % 1000 + i * 1000;
					}
					if(tmp != q && prime.get(tmp) && !visited[tmp]) {
						visited[tmp] = true;
						queue.add(new Point(tmp, que.cnt + 1));
					}
				}
			}
		}
		
	}
	

}
