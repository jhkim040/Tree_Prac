package test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test01 {
	static int[] parents; // �θ� ���
	static List<Integer>[] adj; // ���� ���(�� ��帶�� ����� ��� ����)
	static boolean[] visit; // �湮 ����
	static int n; // ��� ����
	
	private static void dfs(int v) { // ���� �켱 Ž��
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
			adj[a].add(b); // �� ���� ����� ��� ����
			adj[b].add(a);
		}
		dfs(1); // 1������ Ž���Ͽ� �� ����� �θ��� ã��
		for(int i = 2; i <= n; i++) {
			System.out.println(parents[i]);
		}
	}
}
