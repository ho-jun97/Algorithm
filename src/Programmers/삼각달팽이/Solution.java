package Programmers.삼각달팽이;

import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int[][] tri = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){
                    x++;
                }
                if(i%3==1){
                    y++;
                }
                if(i%3==2){
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(tri[i][j]==0) break;
                list.add(tri[i][j]);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
