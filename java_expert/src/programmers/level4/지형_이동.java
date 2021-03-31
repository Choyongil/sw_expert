package programmers.level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


public class 지형_이동 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] 
				{{1, 4, 8, 10}, 
				 {5, 5, 5, 5}, 
				 {10, 10, 10, 10}, 
				 {10, 10, 10, 20}}
						, 3));
	}
	
	static int N, comp;
	static int[] parents;
	static ArrayList<Edge> edgeList;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static class Pair{
		int x,y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	public static void make() {
		for(int i = 0 ; i < comp ; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static int solution(int[][] land, int height) {
		
		N = land.length;
		int ans = 0;
		
		int[][] visited = new int[N][N];
        for (int[] a : visited) Arrays.fill(a, -1);

        comp = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] >= 0) continue;

                Queue<Pair> q = new LinkedList<>();
                q.offer(new Pair(i, j));
                visited[i][j] = comp;

                while(!q.isEmpty()) {
                    int x = q.peek().x;
                    int y = q.peek().y;
                    q.poll();

                    for (int k = 0; k < 4; k++) {
                        int newX = x + dr[k];
                        int newY = y + dc[k];

                        if (newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                        if (visited[newX][newY] >= 0) continue;
                        if (Math.abs(land[x][y] - land[newX][newY]) > height) continue;

                        visited[newX][newY] = comp;
                        q.offer(new Pair(newX, newY));
                    }
                }

                comp++;
            }
        }

        parents = new int[comp];
        edgeList = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
        	for (int j = 0; j < N; j++) {
				for(int d = 0 ; d < 4 ; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (visited[i][j] == visited[nr][nc]) continue;

                    int p = Math.abs(land[i][j] - land[nr][nc]);
                    edgeList.add(new Edge(visited[i][j],visited[nr][nc],p));
				}
			}
        }
        if(edgeList.size() == 0) return 0;
		Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		
		});
		make();

        int count = 0;
        for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				ans += e.weight;
				if(++count == comp-1) break;
			}
		}
		
		return ans;
		
		// prim
//		ArrayList<int[]> list = new ArrayList<>();
//
//		int[][] adjMatrix = new int[size*size][size*size];
//		
//		for(int i = 0 ; i < size ; i++) {
//			for (int j = 0; j < size; j++) {
//				list.add(new int[] {i,j});
//			}
//		}
//		
//		for(int i = 0 ; i < size*size ; i++) {
//			for (int j = i + 1; j < size * size; j++) {
//				int r = list.get(i)[0];
//				int c = list.get(i)[1];
//				
//				int r2 = list.get(j)[0];
//				int c2 = list.get(j)[1]; 
//				
//				if((c == c2 && r2 - r == 1) || (r == r2 && c2 - c == 1)) {
//					adjMatrix[i][j] = Math.abs(land[r2][c2] - land[r][c]) > height ? Math.abs(land[r2][c2] - land[r][c]) : 0;
//				} else {
//					adjMatrix[i][j] = Integer.MAX_VALUE;
//				}
//				adjMatrix[j][i] = adjMatrix[i][j];
//			}
//		}
//
//		boolean[] visited = new boolean[size*size];
//		int[] minEdge = new int[size*size];
//		Arrays.fill(minEdge, Integer.MAX_VALUE);
//		minEdge[0] = 0;
//		int ans = 0;
//		
//		for(int x = 0 ; x < size * size ; x++) {
//			int minIdx = 0;
//			int min = 987654321;
//			
//			for(int i = 0 ; i < size * size ; i++) {
//				if(!visited[i] && min > minEdge[i]) {
//					min = minEdge[i];
//					minIdx = i;
//				}
//			}
//			ans += min;
//			visited[minIdx] = true;
//			
//			for(int i = 0 ; i < size*size ; i++) {
//				if(!visited[i] && adjMatrix[minIdx][i] != -1 && adjMatrix[minIdx][i] < minEdge[i]) {
//					minEdge[i] = adjMatrix[minIdx][i];
//				}
//			}
//		}
//        return ans;
    }
}
