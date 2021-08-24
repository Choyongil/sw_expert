package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 전화번호_목록 {

	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < T ; tc++) {
			
			n = Integer.parseInt(br.readLine());
			
			// pq 는 안되고 array sort 는 된다.
//			PriorityQueue<String> list = new PriorityQueue<>((o1, o2) -> (o1.compareTo(o2)));
//			list.add("91125426"); list.add("97625999"); list.add("911"); list.add("976");
			List<String> list = new ArrayList<>();
			for(int i = 0 ; i < n ; i++) {
				list.add(br.readLine());
			}
//			System.out.println(list);
			Collections.sort(list);
			boolean flag = true;
			for(int i = 0 ; i < n - 1; i++) {
				String str = list.get(i);
				if(str.length() > list.get(i + 1).length()) continue;
				if(str.equals(list.get(i + 1).substring(0,str.length()))) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
