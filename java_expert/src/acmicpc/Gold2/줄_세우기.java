package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄_세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int[] arr = new int[n+1];
		
		for(int i = 0 ; i <= n ; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			
			list.get(front).add(back);
			arr[back]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= n ; i++) {
			if(arr[i] == 0) queue.add(i);
		}

		while(!queue.isEmpty()) {
			int q = queue.poll();

			sb.append(q).append(" ");
			
			for(int x : list.get(q)) {
				if(--arr[x] == 0) {
					queue.add(x);
				}
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}	
}
