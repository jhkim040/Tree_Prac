package test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test01 {
	static int[] parents; // 부모 노드
	static List<Integer>[] adj; // 인접 행렬(각 노드마다 연결된 노드 저장)
	static boolean[] visit; // 방문 여부
	static int n; // 노드 개수
	
	private static void dfs(int v) { // 깊이 우선 탐색
		visit[v] = true;
		
		for(int i : adj[v]) {
			if(!visit[i]) {
				parents[i] = v;
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		adj = new ArrayList[n + 1];
		parents = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		visit = new boolean[n + 1];
		for(int i = 0; i < n - 1; i++) { 
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b); // 각 노드와 연결된 노드 저장
			adj[b].add(a);
		}
		dfs(1); // 1번부터 탐색하여 각 노드의 부모노드 찾기
		for(int i = 2; i <= n; i++) {
			System.out.println(parents[i]);
		}
	}
}
