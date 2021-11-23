package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 트리의_순회 {

	static int n, in_index[], post[], pre[], idx;
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
//		
//		n = Integer.parseInt(br.readLine());
//		in = new int[n];
//		post = new int[n];
//		st = new StringTokenizer(br.readLine());
//		
//		// 인오더
//		for(int i = 0 ; i < n ; i++) {
//			in[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		// 포스트오더
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0 ; i < n ; i++) {
//			post[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		pre = new int[n];
//		idx = 0;
//		getPreorder(0, n - 1, 0, n - 1);
//		for(int x : pre) {
//			sb.append(x).append(" ");
//		}
//		
//		sb.setLength(sb.length() - 1);
//		System.out.println(sb);
//		
//	}
//	
//	public static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
//		
//		if(inStart <= inEnd && postStart <= postEnd) {
//			
//			int root = post[postEnd];
//			pre[idx++] = root;
//			int nextRootIdx = -1;
//			for(int i = inStart ; i <= inEnd ; i++) {
//				
//				if(in[i] == root) {
//					nextRootIdx = i;
//					break;
//				}
//				
//			}
//			
//			// 왼쪽 자식 노드
//			// nextRootIdx - inStart로 왼쪽 트리에 있는 노드의 수를 파악
//			getPreorder(inStart, nextRootIdx - 1, postStart, postStart + nextRootIdx - inStart - 1);
//			// 오른쪽 자식 노드
//			getPreorder(nextRootIdx + 1, inEnd, postStart + nextRootIdx - inStart, postEnd - 1);
//		}
//		
//	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		in_index = new int[n + 1];
		post = new int[n];
		st = new StringTokenizer(br.readLine());
		
		// 인오더
		for(int i = 0 ; i < n ; i++) {
			in_index[Integer.parseInt(st.nextToken())] = i;
		}
		
		// 포스트오더
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		
		pre = new int[n];
		idx = 0;
		getPreorder(0, n - 1, 0, n - 1);
		for(int x : pre) {
			sb.append(x).append(" ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		
	}
	
	public static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
		
		if(inStart <= inEnd && postStart <= postEnd) {
			
			int root = post[postEnd];
			pre[idx++] = root;
			int nextRootIdx = in_index[post[postEnd]];
			
			// 왼쪽 자식 노드
			// nextRootIdx - inStart로 왼쪽 트리에 있는 노드의 수를 파악
			getPreorder(inStart, nextRootIdx - 1, postStart, postStart + nextRootIdx - inStart - 1);
			// 오른쪽 자식 노드
			getPreorder(nextRootIdx + 1, inEnd, postStart + nextRootIdx - inStart, postEnd - 1);
		}
		
	}
}

/*
15
3 10 13 1 6 4 15 5 8 2 12 7 14 9 11
3 13 10 6 15 4 1 8 12 2 14 11 9 7 5
*/