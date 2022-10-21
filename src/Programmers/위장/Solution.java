package Programmers.위장;
import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> type = new HashMap<>();
        for(String[] cloth : clothes){
            type.put(cloth[1], type.getOrDefault(cloth[1],0) + 1);
        }
        int answer = 1;
        for(String key : type.keySet()){
            answer *= (type.get(key)+1);
        }
        return answer-1;
    }
}