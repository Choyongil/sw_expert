package week0315_0319;

import java.util.Arrays;

public class DisjoinSetTest {

	static int N;				//원소의 갯수
	static int parent[];		
	
	static void make() {
		// 크기가 1인 단위집합을 만든다.
		for(int i = 0 ; i < N ; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parent[a] == a) {
			return a;
		}	
//		return findSet(parent[a]); 					// path compression 전
		return parent[a] = findSet(parent[a]);		// path compression 후
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		
		N = 5;
		parent = new int[N];
		
		// 1. make set
		make();
		
		System.out.println("==union==");
		
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parent));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parent));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parent));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parent));
		System.out.println(union(0,4));
		System.out.println(Arrays.toString(parent));
		
		System.out.println("==find==");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parent));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parent));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parent));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parent));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parent));
		
	}
}
