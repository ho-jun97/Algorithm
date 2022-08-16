package Programmers.단속카메라;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1,o2)->Integer.compare(o1[1],o2[1])); // 각 구간에 높은 크기에 대하여 정렬

        int std = Integer.MIN_VALUE;
        for(int i=0; i<routes.length; i++){
            if(std < routes[i][0]){
                answer++;
                std = routes[i][1];
            }
        }
        return answer;
    }
}
