package Programmers.성격유형검사하기;

import java.util.*;
class Solution {
    static char[][] info = {{'R','T'}, {'C', 'F'}, {'J','M'}, {'A','N'}};
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 1. 유형별 점수 초기화
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i=0; i < info.length; i++){
            for(int j=0; j < 2; j++){
                hash.put(info[i][j],0);
            }
        }
        //  4를 기준으로 점수 계산하기
        for(int i=0; i<survey.length; i++){
            // 4보다 크면 오른쪽에 점수
            if(4 < choices[i]){
                char ch = survey[i].charAt(1);
                hash.put(ch, hash.get(ch) + choices[i] - 4);
            }
            // 4보다 작으면 왼쪽에 점수
            if(4 > choices[i]){
                char ch = survey[i].charAt(0);
                hash.put(ch, hash.get(ch)+ 4 - choices[i]);
            }
        }
        for(int i=0; i<info.length; i++){
            int a = hash.get(info[i][0]);
            int b = hash.get(info[i][1]);
            if(a>=b){
                answer += info[i][0];
            }else{
                answer += info[i][1];
            }
        }
        return answer;
    }
}
