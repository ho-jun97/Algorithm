package Programmers.구명조끼;

import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int sum = people[right--];
        while(left <= right){
            if(sum + people[left] <= limit){
                sum += people[left++];
            }else{
                answer++;
                sum = people[right--];
            }
        }
        if(sum <= limit) answer++;
        return answer;
    }
}
