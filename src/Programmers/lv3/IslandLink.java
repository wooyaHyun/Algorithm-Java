/*	
 * Programmers
 * Category	: Greedy(MST)
 * Title	: 구명보트
 */ 
package Programmers.lv3;

import java.util.*;
/*
 * MST 는 가중치 무방향 그래프에서 최소 비용으로 모든 정점을 연결하는 방법
 * 사이클 발생하면 안됨
 * 간선의 수 = 정점-1 일때 최소의 비용을 가짐
 * 방법에는 1.크루스칼 알고리즘과 2. 프림 알고리즘이 있다.
 * 1. 크루스칼 알고리즘은 간선을 기준으로 트리를 형성
 * 2. 프림 알고리즘은 정점을 기준으로 트리 형성 
 * 사이클은 같은 그래프에 속한 두노드를 연결했을 때 발생하고 
 * 이는 Union find 함수로 판별할 수 있다.
 */

public class IslandLink {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution s = new Solution();
		
		int n = 4;
		int[][] costs = {
				{0, 1, 1},
				{0, 2, 2},
				{1, 2, 5},
				{1, 3, 1},
				{2, 3, 8}
		};

		System.out.println(s.solution(n, costs));
	}
}

class Solution {
	int[] parent;
	
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (c1, c2)-> c1[2]-c2[2]);
        
        parent = new int[n];
        for(int i = 0; i < n; i++) {
        	parent[i] = i; //union find 함수를 위해 자기 자신을 parent로 초기화
        }
        
        int total = 0;
        for(int[] c : costs) {
        	int from = c[0];
        	int to = c[1];
        	int cost = c[2];
        	
        	int fromParent = findParent(from);
        	int toParent = findParent(to);
        	
        	//부도노드가 같으면 사이클이 형성되기 때문에 continue
        	if(fromParent == toParent) continue;
        	
        	total += cost;
        	//간선을 연결하면 두 노드가 같은 그래프에 속하게 되므로 부모노드를 갱신
        	parent[toParent] = fromParent;
        }
        answer = total;
        return answer;
    }
    
    public int findParent(int node) {
    	if(parent[node] == node) return node;
    	return parent[node] = findParent(parent[node]);
    	
    }
}