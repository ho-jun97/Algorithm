package BaekJoon.P14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14425
 */
public class Main {
    static int N,M;
    static HashMap<String,Integer> hashMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) { // S집합 HashMap 저장
            String str = br.readLine();
            hashMap.put(str,1);
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(hashMap.containsKey(str)){ // 해당 key가 존재하면 S집합에 포함된 문자열
                answer++;
            }
        }
        System.out.println(answer);
    }
}
