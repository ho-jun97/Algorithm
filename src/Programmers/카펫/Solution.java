package Programmers.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        for(int i=1; i<sum; i++){
            int row = i;
            int col = sum / row;

            if(row <= col){
                if((row-2) * (col-2) == yellow){
                    return new int[]{col,row};
                }
            }
        }
        return answer;
    }
}
