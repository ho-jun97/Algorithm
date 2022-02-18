package BaekJoon.P2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2021
 * [2021번: 최소 환승 경로]-Gold1
 */

public class Main {
    static int N,L;
    static ArrayList<Integer>[] station; // 해당 역이 무슨 노선인지 저장
    static ArrayList<Integer>[] line; // 해당 노선에 무슨 역들이 있는지 저장
    static boolean[] visitedStation;
    static boolean[] visitedLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 역의 개수
        L = Integer.parseInt(st.nextToken()); // 노선의 개수

        station = new ArrayList[N+1];
        line = new ArrayList[L+1];
        visitedStation = new boolean[N+1];
        visitedLine = new boolean[L+1];
        for(int i=1; i<=N; i++){
            station[i] = new ArrayList<>();
        }
        for(int i=1; i<=L; i++){
            line[i] = new ArrayList<>();
        }

        for(int i=1; i<=L; i++){
            st = new StringTokenizer(br.readLine());
            int num=0;
            while((num=Integer.parseInt(st.nextToken()))!=-1){
                station[num].add(i);
                line[i].add(num);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(BFS(start, end));
    }
    static int BFS(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cnt,o2.cnt));
        visitedStation[start] = true; // 출발역 방문처리
        for(int line : station[start]){ // 해당 역이 포함되는 line들을 pq에 넣는다.
            pq.add(new Node(start,line,0));
            visitedLine[line] = true; // 해당 라인 방문처리
        }

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.station == end){ // 끝나는 역에 도착햇을 때
                return now.cnt;
            }
            // 현재 라인에 포함되어 있는 다음 역들
            for(int nextStation : line[now.line]){
                if(!visitedStation[nextStation]){
                    visitedStation[nextStation] = true;
                    pq.add(new Node(nextStation, now.line,now.cnt));
                    // 다음 역들을 포함하고 있는 라인들 -> pq에 저장
                    for(int nextLine : station[nextStation]){
                        if(!visitedLine[nextLine]){
                            visitedLine[nextLine] = true;
                            pq.add(new Node(nextStation,nextLine,now.cnt+1));
                        }
                    }
                }
            }

        }

        return -1;
    }

    static class Node{
        int station;
        int line;
        int cnt;

        public Node(int station, int line, int cnt) {
            this.station = station;
            this.line = line;
            this.cnt = cnt;
        }
    }
}
