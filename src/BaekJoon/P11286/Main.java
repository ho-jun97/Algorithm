package BaekJoon.P11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/11286
 * [11286번: 절대값 힙]-Sliver1
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int com1 = Integer.compare(Math.abs(o1),Math.abs(o2));
                if(com1==0){
                    return Integer.compare(o1,o2);
                }
                return com1;
            }
        });
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n!=0){
                pq.add(n);
            }else{
                if(pq.size()==0) {
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
