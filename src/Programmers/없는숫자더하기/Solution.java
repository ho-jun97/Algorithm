package Programmers.없는숫자더하기;

import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        /**
         *  return 45 - Arrays.stream(numbers).sum();
         */
        int answer = 0;
        boolean[] check = new boolean[10];
        for(int num : numbers){
            check[num] = true;
        }
        for(int i=1; i<=9; i++){
            if(!check[i]) answer += i;
        }
        return answer;
    }
}
