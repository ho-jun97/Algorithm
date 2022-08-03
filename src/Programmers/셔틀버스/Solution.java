package Programmers.셔틀버스;

import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable); // 오름차순 정렬
        Queue<Integer> queue = new LinkedList<>();
        for(String s : timetable){ // 분으로 형변환 후 queue에 저장
            String[] str = s.split(":");
            int time = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            queue.add(time);
        }
        int std = 9*60; // 시작(기준)
        int end = 23*60 + 59; // (끝)
        int count = 0; // 인원수
        //1. 차운행
        for(int i=0; i<n; i++){
            count = 0;
            while(!queue.isEmpty()){
                if(count < m && queue.peek() <= std){
                    int time = queue.poll();
                    count++;
                    end = time - 1;
                }else{
                    break;
                }
            }
            std +=t; // 다음 운행 버스
        }
        if(count < m){ // 아직 탈 수 있는 인원이 될 때
            end = std - t;
        }
        answer = String.format("%02d",end/60) + ":" + String.format("%02d",end%60);

        return answer;
    }
}
