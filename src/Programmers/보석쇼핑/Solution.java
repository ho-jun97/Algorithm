package Programmers.보석쇼핑;

import java.util.*;
public class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        answer = new int[2];
        Set<String> set = new HashSet<>();
        for(String s : gems){
            set.add(s);
        }

        int len = Integer.MAX_VALUE;
        int left=0;
        int right=0;

        Map<String, Integer> map = new HashMap<>();

        while(true){
            // 보석의 종류와 같을 때
            if(set.size() == map.size()){
                map.put(gems[left], map.get(gems[left])-1);

                if(map.get(gems[left])==0){
                    map.remove(gems[left]);
                }
                left++;

                if(len > right-left){
                    len = right-left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }else if(right == gems.length) {
                break;
            }else{ // 오른쪽으로 이동
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;

            }
        }

        return answer;
    }
}