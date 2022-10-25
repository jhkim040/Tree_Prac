package test01;

import java.util.ArrayList;
import java.util.Scanner;



class Node1 {  
	int p;  // ����� ����
	int dist; // ����� ���� ����(����, ����ġ)

	public Node1(int p, int dist) {
		this.p = p;
		this.dist = dist;
	}
}
public class Test1167 {
	static ArrayList<Node1>[] adj; // �������
	static boolean[] visited; // �湮����
	static int max = 0; // ���� �Ÿ�
	static int tmpNode; // ������ �������� ���� �� �Ÿ��� �ִ� ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt(); // ���� ����
		adj = new ArrayList[v + 1];
		for(int i = 1; i <= v; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < v; i++) {
			int n = sc.nextInt(); // �� ���� �Է�
			while(true) {
				int num = sc.nextInt(); // ���� n�� ����� ���� 
				if(num == -1) {  // -1 �Է��ϸ� ���� ���� ����
					break;
				}
				int dist = sc.nextInt(); // ���� ����
				adj[n].add(new Node1(num, dist)); // ������Ŀ� ����
			}
		}

		visited = new boolean[v + 1];
		dfs(1, 0); // ������ ����(1�� ����)���� DFS Ž�� --> ���� �� �Ÿ��� ���� node�� ����

		visited = new boolean[v + 1];
		dfs(tmpNode, 0); // node���� DFS Ž��

		System.out.println(max);
	}
	// ���� p���� ���� ���� �Ÿ��� ���� DFS Ž�� 
	public static void dfs(int p, int len) { 
		if(len > max) {
			max = len; // ���� �Ÿ� ���� 
			tmpNode = p; // ���� �Ÿ��� ���� node�� ����
		}
		visited[p] = true;

		for(Node1 n : adj[p]) {
			if(visited[n.p] == false) {
				dfs(n.p, n.dist + len);
				visited[n.p] = true;
			}
		}
	}

}
