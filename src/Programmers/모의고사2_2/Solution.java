package Programmers.모의고사2_2;

import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> young = new HashMap<>();
        HashSet<Integer> older = new HashSet<>();
        for(int i=0; i<topping.length; i++){
            young.put(topping[i], young.getOrDefault(topping[i],0)+1);
        }
        for(int i=0; i<topping.length; i++){
            older.add(topping[i]);
            if(young.containsKey(topping[i])){
                young.replace(topping[i], young.get(topping[i])-1);
                if(young.get(topping[i])==0){
                    young.remove(topping[i]);
                }
            }
            if(older.size() == young.size()){
                answer++;
            }
        }

        return answer;
    }
}