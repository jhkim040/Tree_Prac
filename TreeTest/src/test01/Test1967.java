package test01;

import java.util.ArrayList;
import java.util.Scanner;


class Node2 {  
	int p;  // 연결된 정점
	int w; // 연결된 간선 정보(길이, 가중치)

	public Node2(int p, int w) {
		this.p = p;
		this.w = w;
	}
}
public class Test1967 {
	static ArrayList<Node2>[] adj; // 인접행렬
	static boolean[] visited; // 방문여부
	static int max = 0; // 최장 거리
	static int tmpNode; // 임의의 정점에서 가장 먼 거리에 있는 정점
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점 개수 입력

		adj = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();	// 부모 노드
			int b = sc.nextInt(); 	// 자식 노드
			int c = sc.nextInt(); 	// 간선 정보(가중치)

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
