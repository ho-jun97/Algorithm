package BaekJoon.P13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13335
 * [13335번: 트럭]-Silver1
 */

public class Main {
    static int N,W,L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken()); // 다리의 길이
        L = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        Queue<Integer> start = new LinkedList<>(); // 출발하려는 차들
        Queue<Integer> ing = new LinkedList<>(); // 다리 위에 있는 차들

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int car = Integer.parseInt(st.nextToken());
            start.add(car);
        }
        for(int i=0; i<W; i++){
            ing.add(0);
        }
        int time=0;
        int sum=0;
        while(!ing.isEmpty()){
            time++;
            sum -= ing.poll();
            if(!start.isEmpty()){
                if(start.peek()+sum <=L){
                    int truck = start.poll();
                    sum += truck;
                    ing.add(truck);
                }else{
                    ing.add(0);
                }
            }
        }
        System.out.println(time);
    }
}
