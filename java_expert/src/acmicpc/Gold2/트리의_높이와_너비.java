package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_높이와_너비 {
	
	public static class Node{
		int num, left, right, parent;
		
		public Node(int num, int left, int right) {
			this.parent = -1;
			this.num = num;
			this.left = left;
			this.right = right;
		}
	}
	static int point = -1;
	static int MaxLevel = 0;
	static int[] MinL, MaxL;
	static List<Node> nodes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		MinL = new int[n+1];
		MaxL = new int[n+1];
		int root = 0;
		nodes = new ArrayList<Node>();
		for(int i = 0 ; i <= n ; i++) {
			nodes.add(new Node(i, -1, -1));
			MinL[i] = n;
			MaxL[i] = 0;
		}
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			nodes.get(x).left = l;
			nodes.get(x).right = r;
			if(l != -1) nodes.get(l).parent = x;
			if(r != -1) nodes.get(r).parent = x;
		}
		
		// root 확인
		for(int i = 1 ; i <= n ; i++) {
			if(nodes.get(i).parent == -1) {
				root = i;
				break;
			}
		}
		
		go(root, 1);
		
		int ansD = 1;
		int ans = 1;
		
		for(int i = 2 ; i <= MaxLevel ; i++) {
			int w = MaxL[i] - MinL[i] + 1;
			if(ans < w) {
				ans = w;
				ansD = i;
			}
		}
		System.out.println(ansD + " " + ans);
		
	}
	
	private static void go(int root, int level) {
		
		Node rootNode = nodes.get(root);
		
		if(MaxLevel < level) MaxLevel = level;
		if(rootNode.left != -1) {
			go(rootNode.left, level+1);
		}
		
		MinL[level] = Math.min(MinL[level], point);
		MaxL[level] = point;
		point++;
		if(rootNode.right != -1) {
			go(rootNode.right, level + 1);
		}
		
	}
}
