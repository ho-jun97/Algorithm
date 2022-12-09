package Programmers.압축;

import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        char temp = 'A';
        // 1. A~Z 넣기
        for(int i=0; i<26; i++){
            String str = String.valueOf((char)(temp+i));
            list.add(str);
        }
        String s = "";
        String history = "";
        for(int i=0; i<msg.length(); i++){
            // 1. list에 포함되는지 확인
            s += msg.charAt(i);
            if(list.contains(s)){
                history = s;
                continue;
            }
            ans.add(list.indexOf(history)+1);
            list.add(s);
            s = "";
            i--;
        }
        ans.add(list.indexOf(history)+1);
        return ans.stream().mapToInt(i->i).toArray();
    }
}