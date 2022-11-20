package Programmers.행렬테두리회전하기;

import java.util.*;
class Solution {
    static int[][] map;
    static int rows;
    static int columns;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        this.rows = rows;
        this.columns = columns;
        // 1. map 만들기
        int cnt = 1;
        map = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = cnt++;
            }
        }
        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int min = 10000;
            // 위 가로
            int store = map[x1][y1];
            for(int j = y1; j < y2; j++){
                min = Math.min(min, store);
                int temp = map[x1][j+1];
                map[x1][j+1] = store;
                store = temp;

            }
            // 오른쪽 세로
            for(int j = x1; j < x2; j++){
                min = Math.min(min, store);
                int temp = map[j+1][y2];
                map[j+1][y2] = store;
                store = temp;

            }
            // 아래 가로
            for(int j = y2; j > y1; j--){
                min = Math.min(min, store);
                int temp = map[x2][j-1];
                map[x2][j-1] = store;
                store = temp;
            }
            // 왼쪽 세로
            for(int j = x2; j > x1; j--){
                min = Math.min(min, store);
                int temp = map[j-1][y1];
                map[j-1][y1] = store;
                store = temp;
            }
            answer[index++] = min;
        }
        return answer;
    }
}
