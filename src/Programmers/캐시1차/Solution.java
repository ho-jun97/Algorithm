package Programmers.캐시1차;

import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) { // 크기가 0이면 담을 수 없기 때문에 모든 도시 개수 * 5
            return cities.length*5;
        }
        int answer = 0;
        List<String> cache = new ArrayList<>();
        for(String city : cities){
            String str = city.toUpperCase();
            // 1. queue에 있는지 확인
            if(cache.contains(str)){
                answer++;
                cache.remove(str);
                cache.add(str);
            }
            // 2. queue에 없고 size가 체크 후 cacheSize이면 queue제거 후 넣기
            else{
                if(cache.size() >= cacheSize){
                    cache.remove(0);
                }
                answer += 5;
                cache.add(str);
            }
        }
        return answer;
    }
}
