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
		
		Queue<Integer> q = new LinkedList<>(); // �θ��带 Ž���� ��常 ����
		boolean[] visit = new boolean[n + 1];
		int[] parent = new int[n + 1];
		
		q.add(1); // ��Ʈ ����� 1���� Ž�� ����
		visit[1] = true; 
		
		while(!q.isEmpty()) {
			int v = q.poll(); // �ϴ� Queue���� ������
			for(int child : adj.get(v)) { 
				if(!visit[child]) {
					visit[child] = true;
					parent[child] = v;
					q.add(child); // �������� Ž���� ���� Level�� �ڽ� ��� ����
				}
			}
		}
		for(int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
	}

}
