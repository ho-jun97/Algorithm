package Programmers.로또의최고순위와최저순위;

import java.util.Arrays;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0, zero = 0;
        Integer[] temp = Arrays.stream(win_nums).boxed().toArray(Integer[]::new);
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0) zero ++;
            if(Arrays.asList(temp).contains(lottos[i])) correct++;
        }
        int max = zero + correct;
        int min = correct;
        return new int[]{Math.min(6,7-max), Math.min(6,7-min)};
    }
}