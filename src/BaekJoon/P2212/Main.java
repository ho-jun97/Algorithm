package BaekJoon.P2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/2212
 * [2212번: 센서]-Gold5
 */

public class Main {
    static int N,K;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        String[] str = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(str[i]));
        }

        // 오름차순 정렬
        Collections.sort(arr);

        ArrayList<Integer> distance = new ArrayList<>();
        for(int i=0; i<N-1; i++){
            distance.add(Math.abs(arr.get(i)-arr.get(i+1)));
        }

        // 차이 내림차순
        Collections.sort(distance, Collections.reverseOrder());

        int answer = 0;
        for(int i=K-1; i<distance.size(); i++){
            // K-1 이유 -> 집중국 K개이면 집중국간에 사이가 K-1개 발생
            // -> 내림차순 정렬했고, 최소를 구하는 문제이기 때문에 K-1부터 더하면 됨
            answer += distance.get(i);
        }
        System.out.println(answer);
    }
}
