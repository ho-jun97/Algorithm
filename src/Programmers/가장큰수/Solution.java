package Programmers.가장큰수;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];

        for(int i = 0; i<numbers.length; i++){
            temp[i] = Integer.toString(numbers[i]);
        }
        // 두개의 숫자를 앞뒤로 한번씩 합쳐서 비교후 정렬
        Arrays.sort(temp, (o1,o2)-> (o1+o2).compareTo(o2+o1));
        for(int i=temp.length-1; i>=0; i--){
            answer += temp[i];
        }
        if(answer.charAt(0)=='0'){
            return "0";
        }
        return answer;
    }
}
