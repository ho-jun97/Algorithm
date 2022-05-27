package BaekJoon.P1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1068
 * [1068번: 트리]-Gold5
 */

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for(int i=0; i<N; i++){
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n == -1){
                root = i;
            }else{
                tree[n].add(i);
            }
        }
        int remove = Integer.parseInt(br.readLine());
        removeNode(remove);
        if(root==remove){
            System.out.println(0);
        }else {
            System.out.println(findLeaf(root));
        }
    }
    static void removeNode(int remove){
        for(int i=0; i<N; i++){
            if(tree[i].contains(remove)){
                tree[i].remove(tree[i].indexOf(remove));
            }
        }
    }
    static int findLeaf(int root){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(tree[node].size()==0){
                count++;
                continue;
            }
            for(Integer n : tree[node]){
                queue.add(n);
            }
        }
        return count;
    }
}
