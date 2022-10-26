package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Test1991 {
	static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	static Node head = new Node('A', null, null);
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, root, left, right);
		}
		
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
	}
	// temp ��忡�� ����
	// root ��忡 
	// ���� �ڽ� ��� left �߰�
	// ������ �ڽ� ��� right �߰�
	public static void insertNode(Node temp, char root, char left, char right) {
		// root ��忡 �����ϸ� �ڽ� ��� �߰�
		if(temp.value == root) {
			// '.'�̸� �ڽĳ�尡 �����Ƿ� �߰� XX
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null));
		}
		// root ��忡 �����ϱ� �� 
		// ���� �켱���� root ��� Ž��
		else {
			if(temp.left != null) {
				insertNode(temp.left, root, left, right);
			}
			if(temp.right != null) {
				insertNode(temp.right, root, left, right);
			}
		}
	}
	// ���� ��ȸ(root -> left -> right) 
	public static void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	// ���� ��ȸ(left -> root -> right)
	public static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	// ���� ��ȸ(left -> right -> root)
	public static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
}














