package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가운데를_말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>((o1 ,o2) -> o2 - o1);
		PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>();

		for(int i = 0 ; i < n ; i ++) {
			int x = Integer.parseInt(br.readLine());
			if(pqMin.size() == pqMax.size()) {
				pqMin.add(x);

				if(!pqMax.isEmpty() && pqMin.peek() > pqMax.peek()) {
					pqMax.add(pqMin.poll());
					pqMin.add(pqMax.poll());
				}
			} else {
				pqMax.add(x);
				
				if(pqMin.peek() > pqMax.peek()) {
					pqMax.add(pqMin.poll());
					pqMin.add(pqMax.poll());
				}
				
			}
			
			sb.append(pqMin.peek()).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
