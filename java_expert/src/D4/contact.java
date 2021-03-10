package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class contact {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10 ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n+1][n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n/2 ; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}

			int ans = start;
			
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			boolean[] visited = new boolean[n+1];
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			queue.add(start);
			visited[start] = true;
			int idx = 0;
			while(true) {
				boolean flag = false;

				while(!queue.isEmpty()) {
					list.add(queue.poll());
				}
				
				int l = list.size();
				
				for(int j = idx ; j < l ; j++) {
					for(int i = 1 ; i <= n ; i++) {
						if(arr[list.get(j)][i] == 1 && !visited[i]) {
							flag = true;
							queue.add(i);
							visited[i] = true;
						}
					}
				}
				idx = l;
				if(!flag) {
					ans = list.get(list.size()-1);
					break;
				}
			}
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
