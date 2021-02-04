package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 암호_생성기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		for(int tc = 1; tc <= 10; tc++) {
			
			sb.append("#" + tc + " ");
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0 ; i < 8 ; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			int q;
			int cnt = 1;
			while (true) {
				q = queue.poll() - cnt++;
				if ( q < 0) q = 0;
				queue.offer(q);
				if (q == 0) break;
				if (cnt == 6) cnt = 1;
			}
			for(int i = 0 ; i < 8 ; i++) {
				sb.append(queue.poll() + " ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
		
	}
}
