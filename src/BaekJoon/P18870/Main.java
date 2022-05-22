package BaekJoon.P18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18870
 * [18870번: 좌표 압축]-Sliver2
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sort = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num;
            sort[i] = num;
        }

        Arrays.sort(sort);
        HashMap<Integer,Integer> hash = new HashMap<>();
        int rank=0;
        for(int i=0; i<N; i++){
            if(!hash.containsKey(sort[i])) {
                hash.put(sort[i], rank++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(hash.get(origin[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
}
