package test02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test2263 {

	static int n;
	static int[] preOrder;
	static int[] inOrder;
	static int[] postOrder;
	static int idx; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		preOrder = new int[n];
		inOrder = new int[n];
		postOrder = new int[n];
		
		String[] newOrder = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(newOrder[i]);
		}
		
		newOrder = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(newOrder[i]);
		}
		getPreOrder(0, n - 1, 0, n - 1);
		
		for(int n : preOrder) {
			bw.write(n + " ");
		}
		bw.flush();
	}
	
	static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart <= inEnd && postStart <= postEnd) {
			preOrder[idx++] = postOrder[postEnd];
			
			int branch = inStart;
			for(int i = inStart; i <= inEnd; i++) {
				if(inOrder[i] == postOrder[postEnd]) {
					branch = i;
					break;
				}
			}
			getPreOrder(inStart, branch - 1, postStart, postStart + branch - inStart - 1);
			getPreOrder(branch + 1, inEnd, postStart + branch - inStart, postEnd - 1);
		}
	}

}
