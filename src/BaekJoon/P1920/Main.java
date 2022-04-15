package BaekJoon.P1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1920
 * [1920번: 수 찾기]-Sliver4
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> setA = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(setA.contains(num)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
