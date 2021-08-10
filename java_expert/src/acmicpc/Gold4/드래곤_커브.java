package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤_커브 {
	
	static int[][] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		check = new int[102][102];
		int x, y, d, g;
		
		// 좌표들을 기억할 리스트
		List<int[]> list;
		int[] dr = {0, -1, 0, 1};
		int[] dc = {1, 0, -1, 0};
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			 
			check[x][y] = 1;
			check[x + dr[d]][y + dc[d]] = 1;
			
			list.add(new int[] {x,y});
			list.add(new int[] {x + dr[d],y + dc[d]});
			
			int[] vertex = new int[] {x + dr[d],y + dc[d]};
			
			// g 세대만큼 커브
			for(int j = 0 ; j < g ; j++) {
				
				int size = list.size();
				int q[], nr, nc;
				int tmp[] = new int[2];
				
				for(int k = 0 ; k < size ; k++) {
					
					q = list.get(k);
					nr = vertex[0] + (q[1] - vertex[1]);
					nc = vertex[1] - (q[0] - vertex[0]);
					
					// 맨 처음 좌표가 다음 세대에서 마지막 꼭지점이 된다.
					if(k == 0) {
						tmp[0] = nr;
						tmp[1] = nc;
					}
					if(nr < 0 || nc < 0 || nr >= 102 || nc >= 102) continue;
					
					list.add(new int[] {nr, nc});
					check[nr][nc] = 1;
					
				}
				
				// vertex 을 새로운 꼭지점으로 최신화
				vertex[0] = tmp[0];
				vertex[1] = tmp[1];
				
			}
		}
		
		System.out.println(square());
		
	}
	
	// 사각형 카운트
	public static int square() {
		
		int sum = 0;
		
		for(int i = 0 ; i < 101 ; i++) {
			for(int j = 0 ; j < 101 ; j++) {
				if(check[i][j] == 1 && check[i + 1][j] == 1 && check[i][j + 1] == 1 && check[i + 1][j + 1] == 1 ) sum++;
			}
		}
		
		return sum;
	}

}
