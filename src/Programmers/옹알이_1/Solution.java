package Programmers.옹알이_1;

import java.util.*;

class Solution {
    static List<String> info = Arrays.asList("aya", "ye", "woo", "ma");
    public int solution(String[] babbling) {
        /**
         * 정규식 표현 방식
         * int answer = 0;
         *
         *         for(int i=0; i<babbling.length; i++){
         *             if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
         *                 answer++;
         *             }
         *         }
         *         return answer;
         */
        int answer = 0;

        for(String bab : babbling){
            String str = "";
            for(int i=0; i<bab.length(); i++){
                str += bab.charAt(i);
                if(info.contains(str)){
                    str = "";
                }
            }
            if(str.equals("")) answer++;
        }
        return answer;
    }
}
