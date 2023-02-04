package Programmers.제일작은수제거하기;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length==1) return new int[]{-1};
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min,arr[i]);
        }
        int index = 0;
        answer = new int[arr.length-1];
        for(int i=0; i<arr.length; i++){
            if(arr[i] == min){
                continue;
            }
            answer[index++] = arr[i];
        }
        return answer;
    }
}