package Programmers.할인행사;

import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i=0; i<discount.length; i++){
            HashMap<String,Integer> hash = new HashMap<>();
            for(int j=i; j<i+10 && j<discount.length; j++){
                hash.put(discount[j], hash.getOrDefault(discount[j],0)+1);
            }
            boolean check = true;
            for(int j=0; j<want.length; j++){
                if(!hash.containsKey(want[j]) || hash.get(want[j]) != number[j]){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}
