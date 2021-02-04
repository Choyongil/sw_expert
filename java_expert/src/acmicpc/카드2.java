package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 2164
public class 카드2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= T ; i++) {
			queue.offer(i);
		}
		
		int q;
		while(queue.size() != 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.poll());
	}
}
