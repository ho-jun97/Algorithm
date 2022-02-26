package BaekJoon.P5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/5639
 * [5639번: 이진 검색 트리]-Gold5
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static class Node{
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }
    }
    static void insert(Node root, Node node){
        // 1. 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
        if(root.num > node.num){ // left
            if(root.left!=null){
                insert(root.left, node);
            }else{
                root.left = node;
            }
        }
        // 2. 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
        else{ //  right
            if(root.right!=null){
                insert(root.right, node);
            }else{
                root.right = node;
            }
        }
    }
    static void postOrder(Node node){ // 후위순회 -> (왼쪽-> 오른쪽 -> 루트)
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        sb.append(node.num).append('\n');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String n;
        while((n=br.readLine()) != null){
            Node node = new Node(Integer.parseInt(n));
            insert(root, node);
        }

        postOrder(root);
        System.out.println(sb.toString());
    }
}
