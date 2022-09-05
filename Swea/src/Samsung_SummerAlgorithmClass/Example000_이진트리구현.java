package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example000_이진트리구현 {
	static int[][] edge;
	static int[] visited;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			//////////////////////////
			
			//tree.insertNode(nodeData);
			
			
			
			///////////////////////////////
			//System.out.println("중위순회");
			//tree.inOrder(tree.root, 0);
			//System.out.println("전위순회");
			//tree.preOrder(tree.root, 0);
			//System.out.println("후위순회");
			//tree.postOrder(tree.root, 0);
			//////////////////////////
		}
	}
	
static class Node {
	int value;
	String str;
	Node left;
	Node right;
		
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
	
static class BinaryTree {
	Node root = null;
	// 노드삽입 method
	public void insertNode(int element) {
		// 루트가 null일 때
		if(root == null) {
			root = new Node(element);
		} else {
			Node head = root;
			Node current;
			
			while(true) {
				current = head;
				
				if(head.value > element) {
					head = head.left;
					if(head == null) {
						current.left = new Node(element);
						break;
					}
				} else {
					head = head.right;
					if(head == null) {
						current.right = new Node(element);
						break;
					}
				}
			}
		}
	}
	public void inOrder(Node root, int depth) {
		if(root != null) {
			inOrder(root.left, depth+1);
			System.out.print(root.value + " ");
			inOrder(root.right, depth+1);
		}
	}
	
	public void preOrder(Node root, int depth) {
		if(root != null) {
			System.out.print(root.value + " ");
			preOrder(root.left, depth+1);
			preOrder(root.right, depth+1);
		}
	}
	
	public void postOrder(Node root, int depth) {
		if(root != null) {
			postOrder(root.left, depth+1);
			postOrder(root.right, depth+1);
			System.out.print(root.value + " ");
		}
	}
}

}
