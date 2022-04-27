package Programmers.lv3;

import java.util.*;

//최소신장 트리(MST 문제)
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
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (c1, c2)-> {
        	if(c1[2] > c2[2]) {
        		return 1;
        	}else if(c1[2] == c2[2]) {
        		return c1[0] - c2[0]; 
        	}
        	return -1;
        	
        });
        
        boolean[] isCheck =  new boolean[n];
        
        for(int[] n1: costs) {
        	if(!isCheck[n1[0]]) {
        		
        	}
        }
       
//        for(int[] n1 : costs) {
//        	for(int n2: n1) {
//        		System.out.print(n2 + " ");
//        	}
//        	System.out.println();
//        }
        
        return answer;
    }
}