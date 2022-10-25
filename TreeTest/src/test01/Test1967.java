package test01;

import java.util.ArrayList;
import java.util.Scanner;


class Node2 {  
	int p;  // ����� ����
	int w; // ����� ���� ����(����, ����ġ)

	public Node2(int p, int w) {
		this.p = p;
		this.w = w;
	}
}
public class Test1967 {
	static ArrayList<Node2>[] adj; // �������
	static boolean[] visited; // �湮����
	static int max = 0; // ���� �Ÿ�
	static int tmpNode; // ������ �������� ���� �� �Ÿ��� �ִ� ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // ���� ���� �Է�

		adj = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();	// �θ� ���
			int b = sc.nextInt(); 	// �ڽ� ���
			int c = sc.nextInt(); 	// ���� ����(����ġ)

			adj[a].add(new Node2(b, c));
			adj[b].add(new Node2(a, c));
		}
		visited = new boolean[n + 1];
		dfs(1, 0);
		
		visited = new boolean[n + 1];
		dfs(tmpNode, 0);
		
		System.out.println(max);
	}

	public static void dfs(int p, int len) {
		if(len > max) {
			max = len;
			tmpNode = p;
		}
		visited[p] = true;
		
		for(Node2 n : adj[p]) {
			if(visited[n.p] == false) {
				dfs(n.p, n.w + len);
				visited[n.p] = true;
			}
		}
		
	}

}
