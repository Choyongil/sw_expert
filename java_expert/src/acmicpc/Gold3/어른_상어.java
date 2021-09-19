package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class 어른_상어 {

	static int n, m, k, map[][];
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		Point[][] sea = new Point[n][n];
		Queue<Node> queue = new LinkedList<>();		// 냄새가 남아있는 포인트 저장
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sea[i][j] = new Point(0,0);
				
				if(map[i][j] > 0) {
					sea[i][j].num = map[i][j];
					sea[i][j].time = k;
					queue.add(new Node(i,j));
				}
			}
		}
		
		List<Integer>[] shark = new ArrayList[m + 1];		// 현재 보고있는 방향, 우선순위(위 아래 왼 오)
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= m ; i++) {
			shark[i] = new ArrayList<>();
			shark[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1 ; i <= m ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int l = 0 ; l < 4 ; l++) {
					shark[i].add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
		int ans = 0;
		boolean[] check = new boolean[m + 1];
		while(ans < 5) {
			
			int size = queue.size();
			System.out.println();
			System.out.println("q : " + queue);
			System.out.println("s : " + shark[1]);
			System.out.println("s : " + shark[2]);
			System.out.println("s : " + shark[3]);
			System.out.println("s : " + shark[4]);
			for(int i = 0 ; i < size ; i++) {
				
				Node q = queue.poll();
				
				int sh = sea[q.r][q.c].num;		// 몇번째 상어인지 체크
				System.out.println("sh : " + sh);
				sea[q.r][q.c].time--;				// 냄새가 남아있는 시간 -1
				if(sea[q.r][q.c].time == 0) {
					sea[q.r][q.c].num = 0;
				} else {
					queue.add(q);
				}
				
				boolean flag = false;
				int cur_dir =  shark[sh].get(0);	// 상어가 현재 바라보고 있는 방향
				for(int d = 1 ; d <= 4 ; d++) {
					
					int nr = q.r + dr[shark[sh].get((cur_dir - 1 ) * 4 + d)];
					int nc = q.c + dc[shark[sh].get((cur_dir - 1 ) * 4 + d)];
					
					if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
					
					if(sea[nr][nc].num == 0) {
						sea[nr][nc].num = sh;
						sea[nr][nc].time = k;
						flag = true;
						shark[sh].set(0, shark[sh].get((cur_dir - 1 ) * 4 + d));
						queue.add(new Node(nr,nc));
						break;
					} else {
						
						// 해당 구역에 방금 다른 상어가 온거라면 상어의 num을 비교해서 둘 중 하나는 out
						if(sea[nr][nc].time == k) {
							if(sea[nr][nc].num > sh) {
								sea[nr][nc].num = sh;
							} 
							break;
						}
					}
					
				}
				
				if(!flag) {
					// 새롭게 움직일 구역을 못 찾았다면
					for(int j = 0 ; j < n ; j++) {
						for(int l = 0 ; l < n ; l++) {
							if(sea[j][l].num == sh && sea[j][l].time == k - 1) {
								queue.add(new Node(j,l));
								sea[j][l].time = k;
								break;
							}
						}
					}
					
				}
				
				
			}
			
			
			ans++;
		}
		System.out.println(ans);
	}
}

class Node {
	int r;
	int c;
	public Node(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	@Override
	public String toString() {
		return "Node [r=" + r + ", c=" + c + "]";
	}
	
	
}

class Point {
	int num;
	int time;
	
	public Point(int num, int time) {
		super();
		this.num = num;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Point [num=" + num + ", time=" + time + "]";
	}
	
}
