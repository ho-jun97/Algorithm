package BaekJoon.P2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2042
 * [2042번: 구간 합 구하기]-Gold1
 */

public class Main {
    static int N,M,K;
    static long[] tree;
    static long[] nums;
    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S=1;
        while(S<N){
            S *=2;
        }
        nums =  new long[S];
        for(int i=0; i<N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }
        tree = new long[S*2];
        BUInit();

        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){ // 1일 때 값 변경
                long c = Long.parseLong(st.nextToken());
                BUUpdate(b,c);
            }else{ // 0일 때 구간 합 구하기
                int c = Integer.parseInt(st.nextToken());
                System.out.println(BUQuery(b,c));
            }
        }
    }
    static void BUInit(){
        // leaf노드 초기화
        for(int i=0; i<N; i++){
            tree[S+i] = nums[i];
        }
        // 내부노드 초기화
        for(int i=S-1; i>0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }
    static long BUQuery(int QueryLeft, int QueryRight){
        //리프 노드로부터 시작
        int nodeLeft = S+QueryLeft-1;
        int nodeRight = S+QueryRight-1;
        long sum=0;
        while(nodeLeft <= nodeRight){
            // leftNode 분기 조건
            if(nodeLeft%2==0){ // 왼쪽경계선 짝수일때
                nodeLeft = nodeLeft/2;
            }else{ //왼쪽 경계선 홀수 일때
                sum += tree[nodeLeft];
                nodeLeft = (nodeLeft+1)/2;
            }
            // rightNode 분기 조건
            if(nodeRight%2==0){
                sum += tree[nodeRight];
                nodeRight = (nodeRight-1)/2;
            }else{
                nodeRight = nodeRight/2;
            }
        }
        return sum;
    }
    static void BUUpdate(int target, long value){
        int node = S+target-1; // 리프노드
        tree[node] = value; // 해당 노드 값 변경
        node = node/2; // 부모 노드 이동
        while(node >=1){
            tree[node] = tree[node*2] + tree[node*2+1];
            node = node/2;
        }
    }
}
