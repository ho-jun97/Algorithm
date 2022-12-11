package Programmers.N개의최소공배수;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        if(arr.length==1) return arr[0];

        for(int i=1; i<arr.length; i++){
            int g = gcd(answer,arr[i]);
            answer = (answer * arr[i])/g;
        }
        return answer;
    }
    // 최대 공약수
    static int gcd(int a, int b){
        int r = a%b;
        if(r==0) return b;
        return gcd(b,r);
    }
}
