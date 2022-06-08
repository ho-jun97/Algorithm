package BaekJoon.P10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10867
 * [10867번: 중복 빼고 정렬하기]-Silver5
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
