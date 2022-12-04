package Programmers.다트게임;

import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<dartResult.length(); i++){
            char info = dartResult.charAt(i);
            if(info == '#'){
                stack.add(stack.pop() * -1);
            }else if(info == '*'){
                int a = stack.pop();
                int b = 0;
                if(stack.size()!=0){
                    b = stack.pop();
                }
                if(b!=0){
                    stack.add(b*2);
                }
                stack.add(a*2);
            }else{
                String temp = "";
                while('0' <= info && info <= '9'){
                    temp += info;
                    info = dartResult.charAt(++i);
                }
                int point = Integer.parseInt(temp);
                if(info == 'D'){
                    point = (int)Math.pow(point,2);
                }else if(info == 'T'){
                    point = (int)Math.pow(point,3);
                }
                stack.add(point);
            }
        }
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }
}
