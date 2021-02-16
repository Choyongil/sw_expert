package week0208_0212;


import java.util.LinkedList;
import java.util.Queue;
/**
 * @author THKim
 */
public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size){
		SIZE = size;
		nodes = new char[size+1];// 0인덱스 사용 안함
	}
	
	public boolean isEmpty(){
		return lastIndex == 0;
	}
	
	private boolean isFull(){
		return lastIndex == SIZE;
	}
	
	//완전이진트리로 추가하는 방법
	public void add(char e){
		if(isFull()){
			System.out.println("포화상태입니다..");
			return;
		}
		nodes[++lastIndex] = e;
	}
	public void bfs() {
		Queue<Integer>  queue = new LinkedList<Integer>();
		
		queue.offer(1);
		int current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			if(current*2<=lastIndex) queue.offer(current*2);
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}		
	}
	public void bfs2() {
		Queue<Integer>  queue = new LinkedList<Integer>();
		
		queue.offer(1);
		int current,size,level=0;
		while(!queue.isEmpty()) {
			
			size = queue.size();
			System.out.print("level"+level+" : ");
			while(--size>=0) {
				current = queue.poll();
				System.out.print(nodes[current]+"\t");
				if(current*2<=lastIndex) queue.offer(current*2);
				if(current*2+1<=lastIndex) queue.offer(current*2+1);				
			}
			System.out.println();
			++level;
		}		
	}
	
	// 전위순회
	public void dfs(int curr) {
		
		if( curr > lastIndex) return;
		
		// VLR
		System.out.println(nodes[curr]);
		dfs(curr * 2);
		dfs(curr * 2 + 1);
	}
	
	// 준위순회
	public void dfs2(int curr) {
		
		if ( curr > lastIndex ) return;
		
		// LVR
		dfs(curr * 2);
		System.out.println(nodes[curr]);
		dfs(curr * 2 + 1);
	}
	
	// 후위순회
	public void dfs3(int curr) {
		
		if ( curr > lastIndex ) return;
		
		// LRV
		dfs(curr * 2);
		dfs(curr * 2 + 1);
		System.out.println(nodes[curr]);
	}
	
	// =====================================================================
	
	public void printTreeByPreOrder(){
		System.out.print("PreOrder :");
		printTreeByPreOrder(1);
		System.out.println();
	}
	private void printTreeByPreOrder(int current){
		if(current <= lastIndex){
			System.out.print(nodes[current]+" "); // 현재 노드 방문처리
			printTreeByPreOrder(current*2);// 왼쪽 자식노드 방문처리
			printTreeByPreOrder(current*2+1);// 오른쪽 자식노드 방문처리
		}
	}
	
	public void printTreeByInOrder(){
		System.out.print("InOrder :");
		printTreeByInOrder(1);
		System.out.println();
	}
	
	private void printTreeByInOrder(int current){
		if(current <= lastIndex){
			printTreeByInOrder(current*2);			// 왼쪽 자식노드 방문처리
			System.out.print(nodes[current]+" ");		// 현재 노드 방문처리
			printTreeByInOrder(current*2+1);			// 오른쪽 자식노드 방문처리
		}
	}
		
	public void printTreeByPostOrder(){
		System.out.print("PostOrder :");
		printTreeByPostOrder(1);
		System.out.println();
	}
	private void printTreeByPostOrder(int current){
		if(current <= lastIndex){
			printTreeByPostOrder(current*2);			// 왼쪽 자식노드 방문처리
			printTreeByPostOrder(current*2+1);		// 오른쪽 자식노드 방문처리
			System.out.print(nodes[current]+" ");		// 현재 노드 방문처리
		}
		
	}	
	

	
}