package BaekJoon.P10021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10021
 * [10021번: Watering the Field]-Gold3
 */

public class Main {
    static int N,C;
    static ArrayList<Integer>[] graph;
    static int[] X;
    static int[] Y;
    static int[] Group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        X = new int[N+1];
        Y = new int[N+1];
        Group = new int[N+1];

        for (int i = 1; i <= N; i++) {
            Group[i] = i;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            X[i] = x;
            Y[i] = y;
        }
        System.out.println(function());
    }
    static int function(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Long.compare(o1.value,o2.value));
        for(int i=1; i<=N-1; i++){
            for(int j=i+1; j<=N; j++){
                long dis = (long)Math.pow(Math.abs(X[i]-X[j]), 2) + (long)Math.pow(Math.abs(Y[i]-Y[j]), 2);
                pq.add(new Node(i,j,dis));
            }
        }
        int count=1;
        int sum =0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.value < C){
                continue;
            }
            if(find(now.x) != find(now.y)){
                count++;
                sum += now.value;
                union(now.x, now.y);
            }
            if(count==N){
                return sum;
            }
        }
        return -1;
    }
    static int find(int x){
        if(x == Group[x]){
            return x;
        }
        return find(Group[x]);
    }
    static void union(int x, int y){
        int groupX = find(x);
        int groupY = find(y);

        Group[groupX] = groupY;
    }
    static class Node{
        int x,y;
        long value;

        public Node(int x, int y, long value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
