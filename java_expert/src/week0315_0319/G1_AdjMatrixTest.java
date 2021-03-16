package week0315_0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/

// NxN Matrix를 활용한 그래프 완전탐색
public class G1_AdjMatrixTest {
	
	static int N;
	static boolean[][] adjMatrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		
		StringTokenizer st = null;
		
		for(int i = 0 ; i < C ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		
		bfs();
		
	}

	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		int start = 0;
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			// 현재 정점에 관련한 처리
			System.out.println((char) (current+65));
			
			//인접 정점 탐색
			for(int i = 0 ; i < N ; i++) {
				if(adjMatrix[current][i]	// 인접 정점 
						&& !visited[i]) {	// 미방문 정점
					queue.offer(i);
					visited[i] = true;
				}
			}
			
		}
		
		
	}
}
