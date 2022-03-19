package BaekJoon.P10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10775
 * [10775번: 공항]-Gold2
 */

public class Main {
    static int G,P;
    static int[] Group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine()); // 게이트 수
        P = Integer.parseInt(br.readLine()); //  비행기 수

        // 그룹 초기화화
       Group = new int[G+1];
        for(int i=1; i<=G; i++){
            Group[i] = i;
        }
        int answer = 0;
        for(int i=0; i<P; i++){
            int gate = Integer.parseInt(br.readLine());
            int findGate = find(gate);

            if(findGate==0){
                break;
            }
            answer++;
            union(findGate, findGate-1);
        }
        System.out.println(answer);
    }
    static int find(int x){
        if(Group[x]==x){
            return x;
        }else{
            return Group[x]=find(Group[x]);
        }
    }
    static void union(int x, int y){
        int groupX = find(x);
        int groupY = find(y);

        Group[groupX] = groupY;

    }
}
