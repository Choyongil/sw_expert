package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 서로소_집합 {

	static int n;
	static int[] parents;
	
	static void make() {
		for(int i = 0 ; i < n ; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n];
			make();
//			System.out.println();
//			System.out.println("aaaaa : " +Arrays.toString(parents));
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				
				if(Integer.parseInt(st.nextToken()) == 0) {
					// union
					union(Integer.parseInt(st.nextToken()) - 1,Integer.parseInt(st.nextToken()) - 1);
//					System.out.println("union : " + Arrays.toString(parents));
				} else {
					int a = Integer.parseInt(st.nextToken()) - 1;
					int b = Integer.parseInt(st.nextToken()) - 1;
					sb.append(findSet(a) == findSet(b)? 1 : 0);
//					System.out.println("check : " + Arrays.toString(parents));
				}
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
