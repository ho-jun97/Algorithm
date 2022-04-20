package BaekJoon.P1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1655
 * [1655번: 가운데를 말해요]-Gold2
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            if(!maxHeap.isEmpty() && ! minHeap.isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb.toString());
    }
}
