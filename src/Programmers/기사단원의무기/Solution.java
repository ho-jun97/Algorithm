package Programmers.기사단원의무기;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        //1. 1~number까지 약수의 개수를 구한다.
        for(int i=1; i<=number; i++){
            int cnt = count(i);
            //2-1. 약수개수가 limit를 넘어가면 power
            if(cnt > limit){
                answer += power;
            }else{ //2-2. 약수개수가 limit를 안넘어가면 cnt
                answer += cnt;
            }
        }

        return answer;
    }
    static int count(int num){
        if(num == 1) return 1;
        int cnt = 1;
        for(int i=1; i<=num/2; i++){
            if(num%i==0){
                cnt++;
            }
        }
        return cnt;
    }
}
