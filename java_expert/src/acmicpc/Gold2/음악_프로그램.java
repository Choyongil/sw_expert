package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악_프로그램 {

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
			int k = Integer.parseInt(st.nextToken());
			List<Integer> tmp = new ArrayList<Integer>();
			for(int j = 0 ; j < k ; j++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int j = 0 ; j < tmp.size() ; j++) {
				for(k = j + 1 ; k < tmp.size() ; k++) {
					list.get(tmp.get(j)).add(tmp.get(k));
					arr[tmp.get(k)]++;
				}
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1 ; i <= n ; i++) {
			if(arr[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			sb.append(q).append("\n");
			for(int l : list.get(q)) {
				if(--arr[l] == 0) {
					queue.add(l);
				}
			}
		}
		sb.setLength(sb.length() - 1);
		for(int i = 1 ; i <= n ; i++) {
			if(arr[i] != 0) {
				sb.setLength(0);
				sb.append(0);
			}
		}
		System.out.println(sb);
	}
}
