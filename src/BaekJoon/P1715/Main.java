package BaekJoon.P1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1715
 * [1715: 카드 정렬하기]-Gold4
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while(pq.size()!=1){
            int temp = pq.poll()+pq.poll();
            sum += temp;
            pq.add(temp);
        }
        System.out.println(sum);
    }
}
