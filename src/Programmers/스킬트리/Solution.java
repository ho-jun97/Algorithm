package Programmers.스킬트리;

import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees){
            int index = 0;
            boolean check = true;
            a:for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(skill.contains(Character.toString(c))){
                    if(skill.charAt(index) == c){
                        index++;
                    }else{
                        check = false;
                        break a;
                    }
                }
            }
            if(check){
                answer++;
            }
        }
        return answer;
    }
}
