package Programmers.이중우선순위큐;

import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(String str : operations){
            String[] oper = str.split(" ");
            char op = oper[0].charAt(0);
            int num = Integer.parseInt(oper[1]);
            if(op=='I'){ // 값 추가
                min.add(num);
                max.add(num);
            }else{
                if(min.size() !=0 && max.size() !=0){ //삭제하기 위해서 값이 있을 경우
                    if(num==1){
                        int value = max.poll();
                        min.remove(value);
                    }else{
                        int value = min.poll();
                        max.remove(value);
                    }
                }
            }
        }
        if(min.size() !=0 && max.size() !=0){ // 값이 있으면 최대값 최소값
            answer = new int[]{max.poll(), min.poll()};
        }else{ // 값이 없을 경우
            answer = new int[]{0,0};
        }
        return answer;
    }
}
