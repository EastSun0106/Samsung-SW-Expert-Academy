package Samsung_SummerAlgorithmClass.example004_기초SingleLinkedList연습;

class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;	// 노드의 값
		this.next = null;	// 다음 노드의 위치
	}
}

public class UserSolution {

	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
    private Node head = getNode(0);	// 리스트 시작 노드
    
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	// 초기화
	public void init() {
		head.next = null;
		nodeCnt = 0;
	}

	// 맨 앞에 노드 추가
	public void addNode2Head(int data) {
		Node node = getNode(data);
		node.next = head.next;
		head.next = node;
	}

	// 맨 뒤에 노드 추가
	public void addNode2Tail(int data) {
		Node node = getNode(data);
		if(nodeCnt == 0) {
			addNode2Head(data);
			return;
		}
		
		Node tempNode = head;
		while(tempNode.next != null) {
			tempNode = tempNode.next;
		}
		tempNode.next = node;
	}

	// 지정된 순서(num)에 노드 추가
	public void addNode2Num(int data, int num) {
		if(num < 0) {
			return;
		}
		else if(nodeCnt == 0 || num == 1) {
			addNode2Head(data);
			return;
		} else if(nodeCnt < num) {
			addNode2Tail(data);
			return;
		}
		
		Node node = getNode(data);
		
		Node preNode = head.next;	// head가 가리키는 노드 시작점
		for(int i=1; i<num-1; i++) {
			preNode = preNode.next;	// preNode = 다음 노드
		}
		Node nextNode = preNode.next;	// preNode의 다음 노드(삽입지점)
		preNode.next = node;
		node.next = nextNode;
		
	}

	// 주어진 data 값을 가진 노드 삭제
	public void removeNode(int data) {
		Node preNode = head.next;
		//첫 번째 data가 num일 때
		if(preNode.data == data) {
			head.next = preNode.next;
		}
		while(preNode.next != null && preNode.next.data != data) {
			preNode = preNode.next;
		}
		if(preNode.next != null) {
			preNode.next = preNode.next.next;
		}
	}

	// output[] 배열에 리스트 노드의 data를 차례로 넣고 총 노드 개수를 리턴
	public int getList(int[] output) {
		Node node = head.next;
		output[0] = node.data;
		node = node.next;
		int i=1;
		while(node != null) {
			output[i] = node.data;
			node = node.next;
			i++;
		}
		return i;
	}
}
