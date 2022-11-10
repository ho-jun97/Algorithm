package Programmers.모음사전;

import java.util.*;
class Solution {
    static char[] ch = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        dfs(0,"",0);
        return list.indexOf(word);
    }
    void dfs(int depth, String cur, int count){
        if(depth<=5){
            list.add(cur);
            if(depth == 5){
                return;
            }
        }
        for(int i=0; i<5; i++){
            dfs(depth+1, cur+ch[i], count + 1);
        }
    }
}
