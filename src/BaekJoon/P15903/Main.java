package BaekJoon.P15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15903
 * [15903번: 카드 합체 놀이]-Sliver2
 */

public class Main {
    static int n,m;
    static long[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        card = new long[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            card[i] = Long.parseLong(st.nextToken());
            pq.add(card[i]);
        }
        for(int i=0; i<m; i++){
            long cardA = pq.poll();
            long cardB = pq.poll();
            pq.add(cardA+cardB);
            pq.add(cardA+cardB);
        }
        long sum = 0L;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
