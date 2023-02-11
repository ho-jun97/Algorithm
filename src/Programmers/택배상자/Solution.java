package Programmers.택배상자;

import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int orderIndex = 0;
        for(int i=1; i<=order.length; i++){
            stack.add(i);

            while(!stack.isEmpty()){
                if(order[orderIndex] != stack.peek()) break;

                stack.pop();
                answer++;
                orderIndex++;
            }
        }
        return answer;
    }
}
