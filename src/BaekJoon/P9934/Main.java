package BaekJoon.P9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/9934
 * [9934번: 완전 이진 트리]-Silver1
 */

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // depth (깊이)
        int N = (int)Math.pow(2,K)-1; // 노드의 개수
        String[] str = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(str[i]));
        }
        Node root = buildTree(list, 0, list.size()-1);
        printTree(root);
    }
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    static Node buildTree(List<Integer> list, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node node = new Node(list.get(mid));

        if(start==end){
            return node;
        }
        node.left = buildTree(list,start, mid-1);
        node.right = buildTree(list,mid+1, end);

        return node;
    }
    static void printTree(Node root){
        StringBuilder sb = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                sb.append(node.data).append(" ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
