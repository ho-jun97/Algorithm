package BaekJoon.P2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2138
 * [2138번: 전구와 스위치]-Silver1
 */

public class Main {
    static int N;
    static char[][] curState;
    static char[] changeState;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        curState = new char[2][N];
        curState[0] = br.readLine().toCharArray();
        changeState = br.readLine().toCharArray();


        // curState[0] : 첫 번째 스위치 off
        // curState[1] : 첫 번째 스위치 on
        for(int i=0; i<N; i++){
            curState[1][i] = curState[0][i];
        }

        function(0,0);

        // 첫 번째 스위치 on
        change(1,0);

        function(1,1);

        answer = answer==Integer.MAX_VALUE?-1:answer;
        System.out.println(answer);
    }
    static void change(int cur, int index){
        for(int i=index-1; i<=index+1; i++){
            if(0<=i && i<changeState.length) {
                curState[cur][i] = curState[cur][i] == '0' ? '1' : '0';
            }
        }
    }
    static void function(int cur,int count){
        for(int i=1; i<N; i++){
            if(curState[cur][i-1] != changeState[i-1]){
                change(cur,i);
                count++;
            }
        }
        if(curState[cur][N-1] == changeState[N-1]){
            answer = Math.min(answer, count);
        }
    }
}
