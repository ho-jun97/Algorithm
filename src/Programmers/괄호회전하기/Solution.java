package Programmers.괄호회전하기;

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] c = s.toCharArray();
        int len = s.length();
        while(len-- > 0){
            if(check(c)){
                answer += 1;
            }
            c = rotate(c);
        }
        return answer;
    }
    // 1칸씩 회전
    static char[] rotate(char[] c){
        char[] t = new char[c.length];
        for(int i=0; i<c.length-1; i++){
            t[i] = c[i+1];
        }
        t[c.length-1] = c[0];
        return t;
    }
    // 올바른 괄호 배열인지 확인하는 함수
    static boolean check(char[] s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length; i++){
            char c = s[i];
            if(stack.isEmpty()){
                stack.add(c);
                continue;
            }
            if(c == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            else if(c == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
            else if(c == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
