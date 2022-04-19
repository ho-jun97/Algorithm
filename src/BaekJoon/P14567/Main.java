package BaekJoon.P14567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13023
 * [14567번: 선수과목]-Gold5
 */

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] indegree;

    static class Subject{
        int num;
        int semester;

        public Subject(int num, int semester) {
            this.num = num;
            this.semester = semester;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        graph = new ArrayList[N+1];

        // 그래프 초기화
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            indegree[to] += 1;
            graph[from].add(to);
        }

        Queue<Subject> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){ //  우선순위가 0인거를 큐에 넣음
                queue.add(new Subject(i,1));
            }
        }
        Integer[] answer = new Integer[N]; // 답을 담은 배열
        while(!queue.isEmpty()){
            Subject sub = queue.poll(); // 0번을 꺼냄
            answer[sub.num-1] = sub.semester; // 해당하는 학기 저장
            for(Integer i : graph[sub.num]){
                indegree[i]--; // 순위 다운
                if(indegree[i]==0){ // 그 순위가 0순위이면 queue에 저장
                    queue.add(new Subject(i,sub.semester+1));
                }
            }
        }
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]+" ");
        }
    }
}
