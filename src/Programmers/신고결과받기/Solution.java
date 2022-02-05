package Programmers.신고결과받기;

import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    static public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> hash = new HashMap<>();
        HashMap<String, ArrayList<String>> reported = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            hash.put(id_list[i],i);
            reported.put(id_list[i], new ArrayList<String>());
        }
        for(int i=0; i<report.length; i++){
            String[] str = report[i].split(" ");
            // str[0] 신고한 사람
            // str[1] 신고 받은 사람
            if(!reported.get(str[1]).contains(str[0])){
                reported.get(str[1]).add(str[0]);
            }
        }
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            if(reported.get(id_list[i]).size()>=k){
                for(String str : reported.get(id_list[i])){
                    answer[hash.get(str)]++;
                }
            }
        }
        return answer;
    }
}
