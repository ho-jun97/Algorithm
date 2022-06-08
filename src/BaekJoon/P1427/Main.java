package BaekJoon.P1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1427
 * [1427번: 소트인사이드]-Silver5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        PriorityQueue<Integer> list = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<str.length(); i++){
            list.add(str.charAt(i)-'0');
        }
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()) {
            sb.append(list.poll());
        }
    }
}
