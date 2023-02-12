package Programmers.두개뽑아서더하기;

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i!=j){
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}
