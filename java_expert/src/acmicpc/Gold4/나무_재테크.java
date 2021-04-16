package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 나무_재테크 {
	
	static int n, m, k, arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		int ans = m;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer>[][] treeInfo = new ArrayList[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				treeInfo[i][j] = new ArrayList<Integer>();
			}
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			
			treeInfo[r][c].add(age);
			Collections.sort(treeInfo[r][c]);
		}
		
		int[][] nutri = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			Arrays.fill(nutri[i], 5);
		}
		
		int[] dr = {-1,-1,-1,0,0,1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		for(int year = 0 ; year < k ; year++) {

			// spring & summer
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					int death = 0;
					for(int s = 0 ; s < treeInfo[i][j].size() ; s++){
						if(nutri[i][j] >= treeInfo[i][j].get(s)) {
							nutri[i][j] -= treeInfo[i][j].get(s);
							treeInfo[i][j].set(s, treeInfo[i][j].get(s) + 1);
						} else {
							death += treeInfo[i][j].get(s) / 2;
							treeInfo[i][j].remove(s);
							s--;
							ans--;
						}
					}
					nutri[i][j] += death;
				}
			}
			
			// fall
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					
					for(int s = 0 ; s < treeInfo[i][j].size() ; s++) {
						
						if(treeInfo[i][j].get(s) % 5 != 0) continue;
						
						for(int d = 0 ; d < 8 ; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							
							if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
							treeInfo[nr][nc].add(0,1);
							ans++;
						}
						
					}
					
				}
			}
			
			// winter
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					nutri[i][j] += arr[i][j];
				}
			}
		}
		
		System.out.println(ans);
	}
}
