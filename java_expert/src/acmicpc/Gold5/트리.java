package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {

	static int n, x, root;
	static boolean check[];
	static List<Node> list;
	static class Node {
		int parentNode;		// 부모 노드
		int cnt;			// 자식 노드 개수
		public Node(int parentNode, int cnt) {
			super();
			this.parentNode = parentNode;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		check = new boolean[n];
		list = new ArrayList<>();
		for(int i = 0 ; i < n;  i++) {
			list.add(new Node(i,0));
		}
		
		root = -1;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if(parent == -1) {
				root = i;
				list.get(i).parentNode = parent;
			} else {
				list.get(i).parentNode = parent;
				list.get(parent == -1 ? root : parent).cnt++;
			}
		}
		
		x = Integer.parseInt(br.readLine());
		check[x] = true;
		
		if(list.get(x).parentNode == -1) System.out.println(0);
		else {
			go(x);
	
			int ans = 0;
			for(int i = 0 ; i < n ; i++) {
				if(!check[i] && list.get(i).cnt == 0) ans++;
			}
			System.out.println(ans);
		}
	}
	
	public static void go(int idx) {
		check[idx] = true;
		list.get(list.get(idx).parentNode).cnt--;
		
		for(int i = 0 ; i < n ; i++) {
			if(i == idx) continue;
			if(list.get(i).parentNode == idx) {
				go(i);
			}
		}
	}
}