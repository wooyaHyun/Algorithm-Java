package Programmers.lv2;
import java.util.*;

public class Lifeboat {

	public static void main(String[] args) {
		//input
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		Solution s = new Solution();
		System.out.println(s.solution(people, limit));
		
	}
}

class Solution{
	public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 내림차룸 정렬
        Arrays.sort(people);
        
        int index = 0;
        for(int i = people.length-1 ; i >= index; i--){    
            if(people[i] + people[index] <= limit){
                index++;
                answer++;
            }else{
                answer++;
            } 
        }
        return answer;
	}
}
