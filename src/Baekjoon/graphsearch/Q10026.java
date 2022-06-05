/*	
 * Baekjoon Algorithm
 * Category	: Graph Search
 * Question	: 10026
 * Title	: 적록색약
 */ 
package Baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {
	static int n;
	static char[][] mat;
	static boolean[][] visited;
	static int[] nx = {1, -1, 0, 0};
	static int[] ny = {0, 0, 1, -1};
	static int nomal = 0;
	static int rgb = 0;
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		char tmp = mat[x][y];
		
		for(int i = 0 ; i < 4; i++) {
			int xx = nx[i] + x;
			int yy = ny[i] + y;
			
			if(xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
			
			if(!visited[xx][yy] && mat[xx][yy] == tmp) {
				dfs(xx,yy);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		mat = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				mat[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					nomal++;
				}
			}
		}
		
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 'G') {
					mat[i][j] = 'R';
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					rgb++;
				}
			}
		}
		
		System.out.println(nomal + " " + rgb);
		
	}
}
