package Programmers.뒤에있는큰수찾기;

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        for(int i=0 ; i<numbers.length ; i++) {
            if(stack.isEmpty() || numbers[i]<numbers[i-1]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        // 나머지는 -1
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
