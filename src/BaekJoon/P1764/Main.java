package BaekJoon.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1764
 * [1764번: 듣보잡]-Silver4
 */

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

        HashSet<String> noListen = new HashSet<>(); // 듣도 못한 사람의 수
        ArrayList<String> answer = new ArrayList<>(); // 듣도 보도 못한 사람의 수
        for(int i=0; i<N; i++){
            noListen.add(br.readLine());
        }
        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(noListen.contains(str)){
                answer.add(str);
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
}
