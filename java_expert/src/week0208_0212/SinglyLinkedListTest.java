package week0208_0212;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();

		list.addLastNode("이동욱");
		System.out.println(list.getLastNode());
		list.printList();
		
		list.addLastNode("이지아");
		list.printList();
		
		list.addFirstNode("김태희");
		list.printList();
		
		Node node = list.getNode("이지아");
		list.insertAfterNode(node, "김재환");
		list.printList();

		list.insertAfterNode(node, "박보검");
		list.printList();
		
		System.out.println("선행 노드 없이 노드 추가===================");
		list.insertAfterNode(list.getNode("송강"), "정해인");
		list.printList();
		
		System.out.println("이지아 이전 노드찾기===================");
		System.out.println(list.getNode("이지아"));
		System.out.println(list.getPreviousNode(list.getNode("이지아")));
		
		//L = ( 김태희 이동욱 이지아 박보검 김재환  )
		System.out.println("노드 삭제 후===================");
		list.deleteNode("이지아2");
		list.printList();
		list.deleteNode("이지아");
		list.printList();
		list.deleteNode("김재환");
		list.printList();		
		list.deleteNode("김태희");
		list.printList();		
		list.deleteNode("이동욱");
		list.printList();	
		list.deleteNode("박보검");
		list.printList();
		list.deleteNode("김태희");
		list.printList();
		
	}

}
