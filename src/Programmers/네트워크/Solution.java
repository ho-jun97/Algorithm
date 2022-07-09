package Programmers.네트워크;

import java.util.*;
class Solution {
    static int[] Group;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Group = new int[n+1];

        // 초기화
        for(int i=1; i<=n; i++){
            Group[i] = i;
        }

        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(i!=j && computers[i][j]==1){
                    union(i+1,j+1);
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(Group[i]==i) answer++;
        }
        return answer;
    }
    // 어떤 그룹에 속하는지 확인하기
    public int find(int x){
        if(Group[x]==x){
            return x;
        }

        return find(Group[x]);
    }
    // 그룹 합치기
    public void union(int a, int b){
        int groupA = find(a);
        int groupB = find(b);

        if(groupA>groupB){
            Group[groupA] = groupB;
        }else{
            Group[groupB] = groupA;
        }

    }
}
