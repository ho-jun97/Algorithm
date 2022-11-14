package Programmers.큰수만들기;

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        stack.add(number.charAt(0));
        for(int i=1; i<number.length(); i++){
            // 1. 스택에 맨위가 다음 숫자보다 작을 경우
            if(stack.peek()-'0' < number.charAt(i) - '0'){
                while(!stack.isEmpty() && stack.peek() -'0' < number.charAt(i) - '0' && cnt<k){
                    stack.pop();
                    cnt++;
                }
            }
            stack.add(number.charAt(i));
        }
        while(cnt < k && !stack.isEmpty()){
            stack.pop();
            cnt++;
        }
        while(!stack.isEmpty()){
            answer = stack.pop() + answer;
        }
        return answer;
    }
}
