package Programmers.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(!stack.isEmpty() && stack.peek() == num){
                stack.pop();
            }
            stack.add(num);
        }
        // stack을 int[] 변환
        return stack.stream().mapToInt(i->i).toArray();
    }
}
