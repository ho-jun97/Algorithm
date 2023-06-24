package leetCode.ValidParentheses;

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.add(s.charAt(i));
                continue;
            }
            if(stack.empty()){
                return false;
            }
            if(c == ')' && stack.peek()=='('){
                stack.pop();
            }
            else if(c == '}' && stack.peek()=='{'){
                stack.pop();
            }
            else if(c == ']' && stack.peek()=='['){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
