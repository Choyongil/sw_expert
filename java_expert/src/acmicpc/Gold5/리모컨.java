package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 리모컨 {

	static int n, length;
	static boolean[] check;
	static PriorityQueue<Num> pq;
	static class Num{
		int n, cnt;

		public Num(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		length = Integer.toString(n).length();
		int k = Integer.parseInt(br.readLine());
		check = new boolean[10];
		
		if(k > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < k ; i++) {
				int x = Integer.parseInt(st.nextToken());
				check[x] = true;
			}
		}
		
		if(n == 100) {
			System.out.println(0);
			return;
		}
		pq = new PriorityQueue<>((o1, o2) -> (o1.cnt - o2.cnt));
		pq.add(new Num(100, Math.abs(n - 100)));
		go(0,"");
		if(length > 1) go2(0,"");
		go3(0,"");

		System.out.println(pq.poll().cnt);
	}
	
	public static void go(int cnt, String x) {
		
		if(cnt == length) {
			if( pq.peek().cnt > length + Math.abs(n - Integer.parseInt(x))) {
				pq.add(new Num(Integer.parseInt(x), length + Math.abs(n - Integer.parseInt(x))));
			}
			return;
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			if(!check[i]) {
				go(cnt+1, x + Integer.toString(i).charAt(0));
			}
		}
	}
	
	public static void go2(int cnt, String x) {
		if(cnt == length - 1) {
			if( pq.peek().cnt > length - 1 + Math.abs(n - Integer.parseInt(x))) {
				pq.add(new Num(Integer.parseInt(x), length - 1 + Math.abs(n - Integer.parseInt(x))));
			}
			return;
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			if(!check[i]) {
				go2(cnt+1, x + Integer.toString(i).charAt(0));
			}
		}
	}

	public static void go3(int cnt, String x) {
		
		if(cnt == length + 1) {
			if( pq.peek().cnt > length + 1 + Math.abs(n - Integer.parseInt(x))) {
				pq.add(new Num(Integer.parseInt(x), length + 1 + Math.abs(n - Integer.parseInt(x))));
			}
			return;
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			if(!check[i]) {
				go3(cnt+1, x + Integer.toString(i).charAt(0));
			}
		}
	}
}