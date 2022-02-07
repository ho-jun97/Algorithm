package BaekJoon.P2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2164
 */
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        // 1. N~1순으로 큐 저장
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        while(queue.size()!=1) {
            // 2. 제일 위에 카트 버림
            queue.poll();
            // 3. 그 다음 제일 위에 있는 카드 제일 밑으로
            int temp = queue.poll();
            queue.add(temp);
        }
        System.out.println(queue.poll());
    }
}
