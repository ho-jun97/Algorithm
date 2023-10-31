package Programmers.개인정보수집유효기간;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(String t : terms){
            String[] s = t.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        int to = getDay(today);
        for(int i=0; i<privacies.length; i++){
            String[] pri = privacies[i].split(" ");
            
            int day = getDay(pri[0]) - 1;
            
            if(day + map.get(pri[1])*28 < to){
                ans.add(i+1);   
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    static int getDay(String date){
        String[] d = date.split("[.]");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        
        return (year*12*28) + (month*28) + day;
    }
}
