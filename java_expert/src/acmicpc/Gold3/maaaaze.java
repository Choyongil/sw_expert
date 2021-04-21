package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class maaaaze {

	static List<int[][]> list;
	static int[] numbers;
	static int ans;
	
	static class Point{
		int x;
		int y;
		int z;
		int cnt;
		
		public Point(int x, int y, int z, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		list = new ArrayList<>();
		
		int[][][] arr = new int[5][5][5];
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < 5 ; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			list.add(rotate(arr[i]));
			for(int j = 0 ; j < 3 ; j++) {
				list.add(rotate(list.get(i*4 + j)));
			}
		}
		numbers = new int[5];
		
		ans = 987654321;
		perm(0);
		System.out.println(ans == 987654321 ? -1 : ans);
	}
	
	static int[][][] map;
	public static void perm(int cnt) {
		if(cnt == 5) {
			shuffle(0);
			return;
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			numbers[cnt] = i;
			perm(cnt+1);
		}
	}
	
	static int[] input = new int[5];
	static boolean[] isSelected = new boolean[5];
	public static void shuffle(int cnt) {
		if(cnt == 5) {
			map = new int[5][5][5];
			for(int i = 0 ; i < 5 ; i++) {
				map[input[i]] = list.get(4 * i + numbers[i]);
			}
			if(map[0][0][0] == 0 || map[4][4][4] == 0) return;
			
			go();
			return;
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			input[cnt] = i;
			shuffle(cnt+1);
			isSelected[i] = false;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	public static void go() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0,0,0));
		
		boolean[][][] visited = new boolean[5][5][5];
		visited[0][0][0] = true;

		while(!queue.isEmpty()) {
			Point q = queue.poll();
			
			if(q.x == 4 && q.y == 4 && q.z == 4) {
				ans = Math.min(ans, q.cnt);
				return;
			}
			for(int d = 0 ; d < 6 ; d++) {
				int nx = q.x + dr[d];
				int ny = q.y + dc[d];
				int nz = q.z + dz[d];
				
				if(nx < 0 || ny < 0 || nz < 0 || nx > 4 || ny > 4 || nz > 4 || map[nx][ny][nz] == 0 || visited[nx][ny][nz]) continue;
				visited[nx][ny][nz] = true;
				queue.offer(new Point(nx,ny,nz,q.cnt+1));
			}
		}
	}
	
	public static int[][] rotate(int[][] arr){
		int[][] tmp = new int[5][5];
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				tmp[j][5-i-1] = arr[i][j];
			}
		}
		return tmp;
	}
}
