package 정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종교 {

	static int N;
	static int parents[];		
	
	static void make() {
		// 크기가 1인 단위집합을 만든다.
		for(int i = 1 ; i <= N ; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}	
//		return findSet(parent[a]); 					// path compression 전
		return parents[a] = findSet(parents[a]);		// path compression 후
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		make();
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int sum = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(parents[i] == i) {
				sum++;
			}
		}
		System.out.println(sum);
	}
}
