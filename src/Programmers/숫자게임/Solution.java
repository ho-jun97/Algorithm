package Programmers.숫자게임;

import java.util.*;
class Solution {
    boolean[] check;
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int indexB = B.length-1;
        for(int i=A.length-1; i>=0; i--){
            if(A[i] < B[indexB]){
                answer++;
                indexB--;
            }
        }
        return answer;
    }
}
