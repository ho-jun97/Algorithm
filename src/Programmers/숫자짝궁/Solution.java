package Programmers.숫자짝궁;

import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        String ans = "";
        //1. 공통된 요소들 찾기
        HashMap<String,Integer> xMap = new HashMap<>();
        HashMap<String,Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();
        for(String str : X.split("")){
            xMap.put(str, xMap.getOrDefault(str,0)+1);
        }
        for(String str : Y.split("")){
            yMap.put(str, yMap.getOrDefault(str,0)+1);
        }
        for(String key : xMap.keySet()){

            if(!(yMap.containsKey(key))){
                continue;
            }

            int len = Math.min(xMap.get(key), yMap.get(key));
            for(int i=0; i<len; i++){
                list.add(key);
            }
        }
        answer = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());

        if(list.size()==0) return "-1";
        if(answer.replaceAll("0","").equals("")) return "0";

        return answer;
    }
}
