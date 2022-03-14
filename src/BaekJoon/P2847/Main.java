package BaekJoon.P2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2847
 * [2847번: 게임을 만든 동준이]-Sliver4
 */

public class Main {
    static int N;
    static int[] stagePoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stagePoint = new int[N];

        for(int i=0; i<N; i++){
            stagePoint[i] = Integer.parseInt(br.readLine());
        }
        int standard = stagePoint[N-1];
        int count=0;
        for(int i=N-2; i>=0; i--){
            while(standard<=stagePoint[i]){
                stagePoint[i]--;
                count++;
            }
            standard = stagePoint[i];
        }
        System.out.println(count);
    }
}
