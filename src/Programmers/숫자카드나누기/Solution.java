package Programmers.숫자카드나누기;

class Solution {
    static int gcd(int a, int b){

        while(b > 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    static boolean check(int g, int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] % g == 0) return false;
        }
        return true;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        // a 배열 최대공약수 구하기
        int gcdA = arrayA[0];
        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        // b 배열 최대공약수 구하기
        int gcdB = arrayB[0];
        for(int i=1; i<arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        if(check(gcdA, arrayB)){
            answer = gcdA;
        }
        if(check(gcdB, arrayA)){
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

}