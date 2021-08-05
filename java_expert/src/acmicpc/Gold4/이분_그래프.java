package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분_그래프 {

	static int n, group[];
	static List<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list = new ArrayList[n+1];
			group = new int[n+1];			// 정점의 그룹을 판별할 수 있는 배열
			
			for(int i = 1 ; i <= n ; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0 ; i < e ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list[a].add(b);
				list[b].add(a);
			}
			
			boolean flag = true;
			out: for(int i = 1 ; i <= n ; i++) {
				if(group[i] == 0) {
					group[i] = 1;
					if(!bfs(i)) {
						sb.append("NO");
						flag = false;
						break out;
					}
				}
			}
			if(flag) sb.append("YES");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);

		while(!queue.isEmpty()) {
			int q = queue.poll();
			
			for(int t : list[q]) {
				if(group[t] == 0) {
					group[t] = group[q] * -1;
					queue.add(t);
				}
				if(group[q] == group[t]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
