package Programmers.롤케이크자르기;

import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> left = new HashSet<>();
        Map<Integer,Integer> right = new HashMap<>();

        //1. 첫번 째 값 빼고 map에 저장(어떤 원소가 몇개있는지)
        for(int i=1; i<topping.length; i++){
            right.put(topping[i], right.getOrDefault(topping[i],0)+1);
        }

        //2. 첫번 째 원소 set에 저장
        left.add(topping[0]);

        for(int i=1; i<topping.length; i++){
            left.add(topping[i]);
            right.replace(topping[i], right.get(topping[i])-1);
            if(right.get(topping[i]) == 0){ // 오른쪽에 없음
                right.remove(topping[i]);
            }
            if(right.size() == left.size()){ // 크기가 같으면 공평한 경우
                answer++;
            }
        }
        return answer;
    }
}
