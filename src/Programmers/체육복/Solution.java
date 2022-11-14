package Programmers.체육복;

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(reserve);
        List<Integer> lostList = new ArrayList<>();
        for(int i : lost){
            lostList.add(i);
        }
        // 여벌있는 학생이 잃어버렸을 경우부터 처리
        for(int i=0; i<reserve.length; i++){
            if(lostList.contains(reserve[i])){
                lostList.remove(Integer.valueOf(reserve[i]));
                reserve[i] = -1;
            }
        }
        // 1. 빌려줄 수 있는 애 체크
        for(int i=0; i<reserve.length; i++){
            if(reserve[i]==-1) continue;
            // 2. 양옆 확인 후 lost에 있으면 빌려주기
            if(lostList.contains(reserve[i]-1)){
                lostList.remove(Integer.valueOf(reserve[i]-1));
                continue;
            }
            if(lostList.contains(reserve[i]+1)){
                lostList.remove(Integer.valueOf(reserve[i]+1));
                continue;
            }
        }
        return n - lostList.size();
    }
}
