package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 지희의_고장난_계산기 {

	static class Num{
		int n;
		int cnt;
		public Num(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			boolean[] num = new boolean[10];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 10 ; i++) {
				if(Integer.parseInt(st.nextToken()) == 1) num[i] = true;
			}

			int n = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[n+1];			// 큐에 들어왔는지 확인할 배열
			Queue<Num> queue = new LinkedList<>();	// 가능한 모든 수 list
			List<Integer> list = new ArrayList<>();		// 약수 저장 list
			out : for(int i = 1 ; i <= n ; i++) {
				if(n % i == 0) {
					String str = Integer.toString(i);
					for(int j = 0 ; j < str.length() ; j++) {
						if(!num[str.charAt(j) - '0']) continue out;  
					}
					list.add(i);
					check[i] = true;
					queue.add(new Num(i,Integer.toString(i).length()));
				}
			}

			int ans = 987654321;
			if(n == 1 && check[1]) ans = 2;
			else{
				while(!queue.isEmpty()) {
				
					Num q = queue.poll();
					if(q.n == n) {
						ans = Math.min(ans, q.cnt + 1);
						break;
					}
					
					for(int i = 0 ; i < list.size() ; i++) {
						if(q.n * list.get(i) < 0 || q.n * list.get(i) > n) break;
						if(list.get(i) <= 1 || check[q.n * list.get(i)]) continue;
						check[q.n * list.get(i)] = true;
						queue.add(new Num(q.n * list.get(i), q.cnt + 1 + Integer.toString(list.get(i)).length()));  
					}
				}
			}
			
			sb.append(ans == 987654321 ? -1 : ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
