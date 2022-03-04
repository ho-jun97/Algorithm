package BaekJoon.P1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1744
 * [1744번: 수 묶기]-Gold4
 */

public class Main {
    static int N;
    static int[] arr;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 오름차순정렬
        used = new boolean[N];
        int answer =0;
        // 1. 음수*음수
        for(int i=0; i<N-1; i+=2){
            if(arr[i]<1 && arr[i+1]<1){
                if(used[i]==false && used[i+1]==false) {
                    answer += arr[i] * arr[i + 1];
                    used[i] = true; // 묶음 처리
                    used[i + 1] = true; // 묶음 처리
                }
            }
        }
        // 2. 양수*양수(1은 제외)
        for(int i=N-1; i>0; i-=2){
            if(arr[i]>1 && arr[i-1]>1) {
                if (used[i] == false && used[i - 1] == false) {
                    answer += arr[i] * arr[i - 1];
                    used[i] = true; // 묶음 처리
                    used[i - 1] = true; // 묶음 처리
                }
            }
        }
        // 3. 나머지 다 더하기
        for(int i=0; i<N; i++){
            if(!used[i]){ // 묶음 처리 안된 부분들 더하기
                answer += arr[i];
            }
        }
        System.out.println(answer);
    }
}
