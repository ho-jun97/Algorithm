package BaekJoon.P11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11728
 * [11728번: 배열 합치기]-Silver5
 */

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
        M = Integer.parseInt(st.nextToken()); // 배열 B의 크기

        ArrayList<Integer> A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> B = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int indexA=0, indexB = 0;

        while(indexA < N && indexB<M){
            int a = A.get(indexA);
            int b = B.get(indexB);
            if(a<=b){
                ans.add(a);
                indexA++;
            }else{
                ans.add(b);
                indexB++;
            }
        }
        for(;indexA<N;indexA++){
            ans.add(A.get(indexA));
        }
        for(;indexB<M;indexB++){
            ans.add(B.get(indexB));
        }
        StringBuilder sb = new StringBuilder();
        for(Integer i : ans){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
