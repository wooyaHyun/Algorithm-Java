/*	
 * Programmers
 * Category	: Greedy(MST)
 * Title	: ����Ʈ
 */ 
package Programmers.lv3;

import java.util.*;
/*
 * MST �� ����ġ ������ �׷������� �ּ� ������� ��� ������ �����ϴ� ���
 * ����Ŭ �߻��ϸ� �ȵ�
 * ������ �� = ����-1 �϶� �ּ��� ����� ����
 * ������� 1.ũ�罺Į �˰���� 2. ���� �˰����� �ִ�.
 * 1. ũ�罺Į �˰����� ������ �������� Ʈ���� ����
 * 2. ���� �˰����� ������ �������� Ʈ�� ���� 
 * ����Ŭ�� ���� �׷����� ���� �γ�带 �������� �� �߻��ϰ� 
 * �̴� Union find �Լ��� �Ǻ��� �� �ִ�.
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
        	parent[i] = i; //union find �Լ��� ���� �ڱ� �ڽ��� parent�� �ʱ�ȭ
        }
        
        int total = 0;
        for(int[] c : costs) {
        	int from = c[0];
        	int to = c[1];
        	int cost = c[2];
        	
        	int fromParent = findParent(from);
        	int toParent = findParent(to);
        	
        	//�ε���尡 ������ ����Ŭ�� �����Ǳ� ������ continue
        	if(fromParent == toParent) continue;
        	
        	total += cost;
        	//������ �����ϸ� �� ��尡 ���� �׷����� ���ϰ� �ǹǷ� �θ��带 ����
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