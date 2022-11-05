package Programmers.모의고사;

import java.util.*;
class Solution {
    int[][] mathGiveUp = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] temp = new int[3];
        int max = 0;
        for(int i=0; i<3; i++){
            int count = 0;
            for(int j=0; j<answers.length; j++){
                if(mathGiveUp[i][j % mathGiveUp[i].length] == answers[j]){
                    count++;
                }
            }
            temp[i] = count;
            max = Math.max(max,count);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == temp[i]){
                list.add((i+1));
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
