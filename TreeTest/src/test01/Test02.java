package test01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		Queue<Integer> q = new LinkedList<>(); // 부모노드를 탐색할 노드만 저장
		boolean[] visit = new boolean[n + 1];
		int[] parent = new int[n + 1];
		
		q.add(1); // 루트 노드인 1부터 탐색 시작
		visit[1] = true; 
		
		while(!q.isEmpty()) {
			int v = q.poll(); // 일단 Queue에서 빼내고
			for(int child : adj.get(v)) { 
				if(!visit[child]) {
					visit[child] = true;
					parent[child] = v;
					q.add(child); // 다음으로 탐색할 동일 Level의 자식 노드 저장
				}
			}
		}
		for(int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
	}

}
