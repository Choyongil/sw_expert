package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위_윷놀이 {

	static int input[], order[], answer;
	static Node start, horse[];
	static class Node {
		
		int val;
		boolean isEmpty, isFinish;
		Node next, fastNext;
		
		Node(int val) {
			this.val = val;
			this.isEmpty = true;
		}
		
		// 노드 연결
		Node addNext(int value) {
			Node nextNode = new Node(value);
			this.next = nextNode;
			return nextNode;
		}
		
		// 노드 찾기 (지름길 놓는 지점을 찾기 위한 함수)
		static Node getNode(Node start, int target) {
			// 시작지점부터 탐색해가며 특정 노드를 찾습니다.
			Node temp = start;
			while(true) {
				if(temp == null) {
					return null;
				}
				if(temp.val == target) {
					return temp;
				}
				temp = temp.next;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		input = new int[11];
		horse = new Node[5];
		order = new int[11];
		
		for(int i = 1 ; i <= 10 ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
		init();
		
		perm(1);
		
		System.out.println(answer);
	}
	
	public static void init() {
		
		start = new Node(0);
		Node tmp = start;
		for(int i = 2 ; i <= 40 ; i += 2) {
			tmp = tmp.addNext(i);
		}
		
		Node end = tmp.addNext(0);
		end.isFinish = true;
		
		end.next = end;
		
		Node crossNode = new Node(25);
		// 25 - 30 - 35 - 40
		tmp = crossNode.addNext(30);
		tmp = tmp.addNext(35);
		tmp.next = Node.getNode(start, 40);
		
		// 10 - 13 - 16 - 19 - 25
		tmp = Node.getNode(start, 10);
		tmp = tmp.fastNext = new Node(13);
		tmp = tmp.addNext(16);
		tmp = tmp.addNext(19);
		tmp.next = crossNode;
		
		// 20 - 22 - 24 - 25(교차점)
		tmp = Node.getNode(start, 20);
		tmp = tmp.fastNext = new Node(22);
		tmp = tmp.addNext(24);
		tmp.next = crossNode;
		
		// 30 - 28 - 27 - 26 - 25(교차점)
		tmp = Node.getNode(start, 30);
		tmp = tmp.fastNext = new Node(28);
		tmp = tmp.addNext(27);
		tmp = tmp.addNext(26);
		tmp.next = crossNode;
	}
	
	public static void perm(int n) {
		if(n > 10) {
			answer = Math.max(answer, game());
			return;
		}
		
		for(int i = 1 ; i <= 4 ; i++) {
			order[n] = i;
			perm(n + 1);
		}
		
	}
	
	public static int game() {
		
		Arrays.fill(horse, start);
		int sum = 0;
		
		for(int i = 1 ; i <= 10 ; i++) {
			
			Node cur = horse[order[i]];	
			
			cur.isEmpty = true;
			
			for(int j = 1 ; j <= input[i] ; j++) {
				
				if(j == 1 && cur.fastNext != null) {
					cur = cur.fastNext;
				} else {
					cur = cur.next;
				}
				
			}
			
			horse[order[i]] = cur;
			
			if(!cur.isEmpty && !cur.isFinish) {
				sum = 0;
				break;
			} else {
				cur.isEmpty = false;
				sum += cur.val;
			}
		}
		
		for(int i = 1 ; i <= 4 ; i++) {
			horse[i].isEmpty = true;
		}
	
		return sum;
	}
	
}
