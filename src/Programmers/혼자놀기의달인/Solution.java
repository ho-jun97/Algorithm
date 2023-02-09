package Programmers.혼자놀기의달인;

import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<cards.length; i++){
            if(cards[i] == -1) continue;

            int size = circleSize(cards,i);
            list.add(size);
        }
        if(list.size()==1){
            return 0;
        }
        Collections.sort(list);
        return list.get(list.size()-1) * list.get(list.size()-2);
    }
    static int circleSize(int[] cards, int index){
        if(cards[index] == -1){
            return 0;
        }

        int next = cards[index]-1;
        cards[index] = -1;

        return circleSize(cards,next) + 1;
    }
}
