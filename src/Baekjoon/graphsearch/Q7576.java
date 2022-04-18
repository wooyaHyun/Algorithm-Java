/*	
 * Baekjoon Algorithm
 * Category	: Graph Search
 * Question	: 7576
 * Title	: 토마토
 */ 

package Baekjoon.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
	static int[][] mat;
	static boolean[][] visited;
	static int n, m;
	static int[] nx = {1, -1, 0, 0 };
	static int[] ny = {0, 0, 1, -1 };
	static Queue<Tomato> q = new LinkedList<>();
	
	public static void tomatoBfs() {

		while(!q.isEmpty()) {
			Tomato t = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int dx = t.lx + nx[i];
				int dy = t.ly + ny[i];
				if(dx >=0 && dy >= 0 && dx < n && dy < m) {
					if(mat[dx][dy] == 0) {
						q.offer(new Tomato(dx, dy));
						mat[dx][dy] = mat[t.lx][t.ly]+1;
					}
				}
				
			}

		}
		
		
	}
	

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		mat = new int[n][m];
		visited = new boolean[n][m];
		
		//토마토가 모두 익은 상태 flag 변수
		boolean flg1 = true;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				mat[i][j] = sc.nextInt();
				if(mat[i][j] == 0 && flg1 == true) {
					flg1 = false; 
				}
			}
		}
		
		//토마토가 모두 익었을 경우
		if(flg1 == true) {
			System.out.println(0);
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mat[i][j] == 1) {
					q.offer(new Tomato(i, j));
				}
			}
		}
		
		tomatoBfs();
		
		//토마토가 모두 익지 못하는 상황 flag 변수
		boolean flg2 = true;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mat[i][j] == 0 && flg2 == true) {
					flg2 = false;
				}
			}
		}
		
		if(flg2 == false) {
			System.out.println(-1);
		}
		
		
		if(flg2 == true && flg1 == false) {
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(mat[i][j] > max ) {
						max = mat[i][j];
					}
				}
			}
			System.out.println(max-1);
		}
		
	}
}

class Tomato{
	int lx, ly;
	public Tomato(int lx, int ly) {
		this.lx = lx;
		this.ly = ly;
	}
}
