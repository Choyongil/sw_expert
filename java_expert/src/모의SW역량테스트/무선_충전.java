package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 무선_충전 {

	static int m, a, ans;
	static BC[] infoA;
	static int[] moveA, moveB;
	
	static class BC implements Comparable<BC>{
		
		int id;
		int x;
		int y;
		int c;
		int p;
		
		public BC(int id, int x, int y, int c, int p) {
			super();
			this.id = id;
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(BC o) {
			return o.p - this.p;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			
			moveA = new int[m];
			moveB = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < m ; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < m ; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			infoA = new BC[a];
			
			for(int i = 0 ; i < a ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				infoA[i] = new BC(i,y,x,c,p);
			}
			ans = 0;
			go();
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	private static void go() {
		
		int rA = 1;
		int cA = 1;
		int rB = 10;
		int cB = 10;
		
		
		for(int i = 0 ; i <= m ; i++) {
			boolean[] check = new boolean[a];
			PriorityQueue<BC> pq1 = new PriorityQueue<BC>();
			PriorityQueue<BC> pq2 = new PriorityQueue<BC>();
			
			for(int n = 0 ; n < a ; n++) {
				BC p = infoA[n];
				
				if(Math.abs(p.x - rA) + Math.abs(p.y - cA) <= p.c) {
					pq1.add(new BC(p.id, p.x, p.y, p.c, p.p));
				}
				
				if(Math.abs(p.x - rB) + Math.abs(p.y - cB) <= p.c) {
					pq2.add(new BC(p.id, p.x, p.y, p.c, p.p));
				}
			}

			int total = 0;
			int sum = 0;
			if(!pq1.isEmpty() && !pq2.isEmpty()) {
				for(BC p1 : pq1) {
					total = Math.max(total, p1.p);
					sum = p1.p;
					check[p1.id] = true;
					for(BC p2 : pq2) {
						if(!check[p2.id])
							total = Math.max(total, sum + p2.p);
					}
					check[p1.id] = false;
				}
				ans += total;
			} else if(!pq1.isEmpty() && pq2.isEmpty()) {
				ans += pq1.poll().p;
			} else if(pq1.isEmpty() && !pq2.isEmpty()) {
				ans += pq2.poll().p;
			}
			
			if(i == m) break;
			rA += dr[moveA[i]];
			cA += dc[moveA[i]];
			rB += dr[moveB[i]];
			cB += dc[moveB[i]];
			
		}
	}
	
	
}
