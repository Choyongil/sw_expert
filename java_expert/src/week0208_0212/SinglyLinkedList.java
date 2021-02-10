package week0208_0212;

public class SinglyLinkedList {

	private Node head;
	
	public void addFirstNode(String data) {
		Node curr = new Node(data, head);
		head = curr;
	}
	
	public Node getLastNode() {
		if (head == null) return null;
		else {
			Node curr = head;
			while(curr.link != null) {
				curr = curr.link;
			}
			return curr;
		}
	}
	
	public void addLastNode(String data) {
		
		Node curr = new Node(data);
		
		if(head == null) head = curr; 
		else getLastNode().link = curr;
		
	}
	
	public void insertAfterNode(Node prev, String data) {
		
		if( prev == null ) {
			System.out.println("Prev nowhere");
			return;
		}
		Node curr = new Node(data, prev.link);
		prev.link = curr;
		
	}
	
	public Node getNode(String data){
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			if (currNode.data.equals(data)) {
				return currNode;
			}
		}
		return null;
	}
	
	public Node getPreviousNode(Node target) {
		
		Node curr = head, nextn = null;
		if( curr != null) {
			while( (nextn = curr.link) != null) {
				if( nextn == target) return curr;
				curr = curr.link;
			}
		}
		
		return null;
	}
	
	public void deleteNode(String data) {
		
		if(head==null){
			System.out.println("공백리스트이어서 삭제가 불가능합니다.");
			return;
		}
		Node targetNode = getNode(data);
		if(targetNode == null) return;
		
		Node preNode = getPreviousNode(targetNode);
		if(preNode == null && targetNode == head) {
			head = targetNode.link;
		}else {
			preNode.link = targetNode.link;
		}
		targetNode.link = null;
	}
	
	public void printList() {
		System.out.print("L = ( ");
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data+" ");
		}
		System.out.println(" )");
	}
	
	
}
