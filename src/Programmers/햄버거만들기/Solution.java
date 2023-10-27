package Programmers.햄버거만들기;

import java.util.*;

class Solution {
    static int[] std = {1,2,3,1};
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int in : ingredient){
            stack.push(in);
            
            if(stack.size() > 3){
                if(stack.get(stack.size()-4) == 1
                  && stack.get(stack.size()-3) == 2
                  && stack.get(stack.size()-2) == 3
                  && stack.get(stack.size()-1) == 1){
                    answer++;
                    int n=4;
                    while(n-->0){
                        stack.pop();
                    }
                }
            }
        }
        return answer;
    }
}
