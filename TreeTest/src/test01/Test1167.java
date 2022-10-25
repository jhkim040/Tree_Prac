package test01;

import java.util.ArrayList;
import java.util.Scanner;



class Node1 {  
	int p;  // 연결된 정점
	int dist; // 연결된 간선 정보(길이, 가중치)

	public Node1(int p, int dist) {
		this.p = p;
		this.dist = dist;
	}
}
public class Test1167 {
	static ArrayList<Node1>[] adj; // 인접행렬
	static boolean[] visited; // 방문여부
	static int max = 0; // 최장 거리
	static int tmpNode; // 임의의 정점에서 가장 먼 거리에 있는 정점

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt(); // 정점 개수
		adj = new ArrayList[v + 1];
		for(int i = 1; i <= v; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < v; i++) {
			int n = sc.nextInt(); // 각 정점 입력
			while(true) {
				int num = sc.nextInt(); // 정점 n과 연결된 정점 
				if(num == -1) {  // -1 입력하면 다음 정점 정보
					break;
				}
				int dist = sc.nextInt(); // 간선 정보
				adj[n].add(new Node1(num, dist)); // 인접행렬에 저장
			}
		}

		visited = new boolean[v + 1];
		dfs(1, 0); // 임의의 정점(1로 설정)에서 DFS 탐색 --> 가장 먼 거리의 정점 node에 저장

		visited = new boolean[v + 1];
		dfs(tmpNode, 0); // node에서 DFS 탐색

		System.out.println(max);
	}
	// 정점 p에서 가장 최장 거리의 정점 DFS 탐색 
	public static void dfs(int p, int len) { 
		if(len > max) {
			max = len; // 최장 거리 갱신 
			tmpNode = p; // 최장 거리의 정점 node에 갱신
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
