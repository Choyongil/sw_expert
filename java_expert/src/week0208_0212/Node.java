package week0208_0212;

public class Node {
	public String data;
	public Node link;
	
	public Node(String data) {
		super();
		this.data = data;
	}
	
	public Node(String data, Node link) {
		this.data = data;
		this.link = link;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}
