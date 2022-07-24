package Programmers.입국심사;

import java.util.*;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times); // 이분탐색을 위해서 오름차순 정렬
        long left = 0;
        long right = (long)n*times[times.length-1]; // 최악의 경우
        while(left <= right){
            long sum = 0;
            long mid = (left+right)/2;
            for(int i=0; i<times.length; i++){
                sum += (mid/times[i]);
            }
            if(sum < n){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
