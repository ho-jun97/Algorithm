package Programmers.다음큰숫자;

class Solution {
    static int convert(int n){
        int cnt = 0;
        while(n>0){
            if(n%2==1) cnt++;
            n /= 2;
        }
        return cnt;
    }
    public int solution(int n) {
        int count = convert(n++);
        while(true){
            int temp = convert(n++);
            if(count == temp){
                n--;
                break;
            }
        }
        return n;
    }
}
