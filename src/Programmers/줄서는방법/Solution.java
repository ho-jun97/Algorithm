package Programmers.줄서는방법;

import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long f = 1;
        int index = 0;

        for(int i=1; i<=n; i++){
            f *= i;
            list.add(i);
        }

        k--;
        while(n > 0){
            f /= n;
            int value = (int)(k/f);
            answer[index++] = list.get(value);
            list.remove(value);

            k %= f;
            n--;
        }

        return answer;
    }
}
