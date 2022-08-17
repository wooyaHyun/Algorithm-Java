/*	
 * Programmers
 * Category	: sort
 * Title	: 가장큰수
 */ 

package Programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxNum {

	public static void main(String[] args) {
		
		Solution2 s = new Solution2();
		
		//int[] numbers = {6, 10, 2};
		int[] numbers = {3, 30, 34, 5, 9};
		
		s.solution(numbers);
	}
	
	
}

class Solution2{
	public String solution(int[] numbers){
        String answer = "";
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
        	list.add(numbers[i]);
        }
        
        Collections.sort(list, (n1, n2) -> {
        	String s1 = String.valueOf(n1);
        	String s2 = String.valueOf(n2);
        	//return -Integer.compare(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));
        	if(Integer.parseInt(s1+s2) > Integer.parseInt(s2 + s1)) {
        		return -1;
        	}
        	else if(Integer.parseInt(s1+s2) == Integer.parseInt(s2 + s1)) {
        		return 0;
        	}
        	return 1;
        		
        });
        
        StringBuilder sb = new StringBuilder();
        for(Integer n : list) {
        	sb.append(n);
        }
        
        answer = sb.toString();
        
        if(answer.charAt(0) == '0') {
        	return "0";
        }
        else {
        	return answer;
        }
    }
}


