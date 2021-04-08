package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i = 0 ; i <= n ; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.get(s).add(e);
			arr[e]++;
			
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i = 1 ; i <= n ; i++) {
			if(arr[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {

			int q = queue.poll();
			sb.append(q).append(" ");
			
//			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
			for(int i : list.get(q)) {
				if(--arr[i] == 0) {
					queue.offer(i);
				}
			}
			
//			for(int x : pq) queue.offer(x);
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
