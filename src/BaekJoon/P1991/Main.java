package BaekJoon.P1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.acmicpc.net/problem/1991
 * [1991번: 트리 순회]-Sliver1
 */

public class Main {
    static int N;
    static ArrayList<Node>[] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            String[] ch = br.readLine().split(" ");
            int data = ch[0].charAt(0)-'A'+1;
            tree[data].add(new Node(ch[1].charAt(0), ch[2].charAt(0)));
        }
        preorder('A');
        sb.append('\n');
        inorder('A');
        sb.append('\n');
        postorder('A');
        System.out.println(sb.toString());
    }
    static void preorder(char node){
        if(node != '.') {
            sb.append(node);
            preorder(tree[node - 'A' + 1].get(0).left);
            preorder(tree[node - 'A' + 1].get(0).right);
        }
    }
    static void inorder(char node){
        if(node != '.') {
            inorder(tree[node - 'A' + 1].get(0).left);
            sb.append(node);
            inorder(tree[node - 'A' + 1].get(0).right);
        }
    }
    static void postorder(char node){
        if(node != '.') {
            postorder(tree[node - 'A' + 1].get(0).left);
            postorder(tree[node - 'A' + 1].get(0).right);
            sb.append(node);
        }
    }
    static class Node{
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}
