/*	
 * Programmers
 * Category	: sort
 * Title	: K¹øÂ°¼ö
 */ 

package Programmers.lv1;

import java.util.*;

public class Knum {
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3},
				{4, 4, 1},
				{1,7,3}
		};
		s.solution(array, commands);
	}

}

class Solution{
	
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = 0; j < array.length; j++) {
				if(j+1 >= commands[i][0] && j+1 <=commands[i][1]) {
					list.add(array[j]);
				}
			}
			Collections.sort(list);
			answer[i] = list.get(commands[i][2]-1);
		}
		
		return answer;
    }

	
}
