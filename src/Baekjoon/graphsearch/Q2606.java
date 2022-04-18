/*	
 * Baekjoon Algorithm
 * Category	: Graph Search
 * Question	: 2606
 * Title	: 바이러스
 */ 

package Baekjoon.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2606 {
	
	static int n, m;
	
	static int[][] mat;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void dfs(int v) {
		
		visited[v] = true;
		cnt++;
		for(int i = 1; i <= n; i++) {
			if(!visited[i] && mat[v][i] == 1) {
				dfs(i);
			}
		}
		
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();

			cnt++;
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && mat[tmp][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] agrc) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		mat = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			mat[a][b] = mat[b][a] = 1;
			
		}
		
		dfs(1);
		//bfs(1);
		System.out.println(cnt-1);
	}
}
