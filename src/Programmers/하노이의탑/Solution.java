package Programmers.하노이의탑;

import java.util.*;
class Solution {
    static ArrayList<int[]> cmd;
    public int[][] solution(int n) {
        cmd = new ArrayList<>();
        
        hanoi(n,1,3,2);
        
        int[][] answer = new int[cmd.size()][2];
        for(int i=0; i<cmd.size(); i++){
            answer[i][0] = cmd.get(i)[0];
            answer[i][1] = cmd.get(i)[1];
        }
        return answer;
    }
    static void hanoi(int n, int from, int to, int mid){
        int[] move = new int[]{from, to};
        
        if(n==1){
            cmd.add(move);
            return;
        }
        hanoi(n-1, from, mid, to);
        cmd.add(move);
        hanoi(n-1, mid, to, from);
    }
}
