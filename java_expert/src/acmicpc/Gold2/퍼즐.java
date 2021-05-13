package acmicpc.Gold2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class 퍼즐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = 0;
		for(int i = 0 ; i < 9 ; i++) {
			int t = sc.nextInt();
			if(t == 0) t = 9;
			k = 10*k + t;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(k, 0);
		queue.offer(k);
		int ans = -1;
		int dr[] = {-1, 1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		while(!queue.isEmpty()) {
			int q = queue.poll();
			
			if(q == 123456789) {
				ans = map.get(q);
				break;
			}
			
			String now = String.valueOf(q);
			int nine = now.indexOf("9");
			int r = nine / 3;
			int c = nine % 3;
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int move = nr*3 + nc;
				if(nr < 0 || nc < 0 || nr >=3 || nc >= 3) continue;
				char tmp = now.charAt(move);
				StringBuilder next = new StringBuilder(now);
				next.setCharAt(move, '9');
				next.setCharAt(nine, tmp);
				int num = Integer.parseInt(next.toString());
				if(!map.containsKey(num)) {
					map.put(num, map.get(q) + 1);
					queue.offer(num);
				}
			}
		}
		System.out.println(ans);
		
		
	}
}
