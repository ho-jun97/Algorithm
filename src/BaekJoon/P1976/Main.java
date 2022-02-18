package BaekJoon.P1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1976
 * [1976번: 여행 가자]-Gold4
 */

public class Main {
    static int N,M;
    static int[] Group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 도시의 수
        M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수
        Group = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Group[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<str.length; j++){
                if(Integer.parseInt(str[j])==1){ // 1일 때만 그룹 합치기
                    union(i,j+1);
                }
            }
        }
        String[] str = br.readLine().split(" ");
        int start = find(Integer.parseInt(str[0]));
        for(int i=1; i<str.length; i++){
            if(start!=find(Integer.parseInt(str[i]))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static void union(int a, int b){ // 그룹 합치기
        int aGroup = find(a);
        int bGroup = find(b);

        Group[bGroup] = aGroup;
    }
    static int find(int n){ // 해당 그룹 찾기
        if(Group[n] == n){
            return n;
        }else{
            return Group[n]=find(Group[n]);
        }
    }
}

