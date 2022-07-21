package Programmers.풍선터트리기;

public class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int left = a[0];
        int right = a[a.length-1];
        int rightIndex = a.length-1;
        for(int i=1; i<a.length-1; i++){
            if(a[i] < left){
                left = a[i];
                answer++;
            }
            if(a[rightIndex-i] < right){
                right = a[rightIndex-i];
                answer++;
            }
            if(left == right){
                answer--;
                break;
            }
        }
        return answer;
    }
}
