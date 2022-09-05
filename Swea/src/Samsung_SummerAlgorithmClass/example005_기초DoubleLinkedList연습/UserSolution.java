package Samsung_SummerAlgorithmClass.example005_기초DoubleLinkedList연습;

import java.util.Arrays;

class Node {
	public int data;
	public Node prev;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class UserSolution {
	
	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;
	private Node tail;
    
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {
		head = getNode(-1);
		tail = getNode(-2);
		head.next = null;
		tail.prev = null;
		nodeCnt = 0;
	}
	
	// 맨 앞에 노드 추가
	public void addNode2Head(int data) {	/////////구현완료
		Node node = getNode(data);
		
		if(head != null) {
			node.next = head;
			head.prev = node;
		}
		head = node;
		if(head.next == null) {
			tail = head;
		}
	}
	
	// 맨 뒤에 노드 추가
	public void addNode2Tail(int data) {
		if(nodeCnt == 0) {
			addNode2Head(data);
		}
		else {
			Node node = getNode(data);
			Node cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = node;
			cur.data = data;
			node.prev = cur;
		}
		
	}

	// num번째에 노드 추가(1-2-3-4-5...)
	public void addNode2Num(int data, int num) {	////// 구현완료
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
		
		Node preNode = head;	// head가 가리키는 노드 시작점
		for(int i=1; i<num-1; i++) {
			preNode = preNode.next;
		}
		Node nextNode = preNode.next;	// preNode의 다음 노드(삽입지점)
		preNode.next = node;
		node.next = nextNode;
		
	}
	
	// data를 가진 node의 순서를 리턴
	public int findNode(int data) {	///////////////구현완료
		int i = 1;
		Node preNode = head;
		//첫 번째 data가 num일 때
		if(preNode.data == data) {
			return i;
		}
		while(preNode.next != null && preNode.next.data != data) {
			preNode = preNode.next;
			i++;
		}
		return i+1;
	}
	
	// data를 가진 노드 삭제
	public void removeNode(int data) {	//////////구현완료
		Node preNode = head;
		//첫 번째 data가 num일 때
		if(preNode.data == data) {
			head = preNode.next;
			nodeCnt--;
			return;
		}
		while(preNode.next != null && preNode.next.data != data) {
			preNode = preNode.next;
		}
		if(preNode.next != null) {
			preNode.next = preNode.next.next;
			nodeCnt--;
		}
	}

	// 노드의 data를 차례대로 output에 저장 후 노드 개수 리턴
	public int getList(int[] output) {		//////////구현완료
		Node node = head;
		output[0] = node.data;
		node = node.next;
		int i=1;
		while(node.next != null) {
			output[i] = node.data;
			node = node.next;
			i++;
		}
		return i;
	}
	
	// 역순 저장 후 개수 리턴
	public int getReversedList(int[] output) {
		int[] tempOutput = new int[nodeCnt];
		for(int i=0; i<nodeCnt; i++) {
			tempOutput[i] = output[nodeCnt-i-1];
		}
		
		for(int i=0; i<nodeCnt; i++) {
			output[i] = tempOutput[i];
		}
		return nodeCnt;
	}
}
