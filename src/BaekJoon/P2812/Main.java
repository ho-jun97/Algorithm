package BaekJoon.P2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2812
 * [2812번: 크게 만들기]-Gold4
 */

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[] number = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<number.length; i++){
            while(K>0 && !stack.isEmpty() && stack.peek() < number[i]) {
                char temp = stack.pop();
                System.out.print(temp+" ");
                K--;
            }
            System.out.println();
            stack.add(number[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stack.size()-K; i++){
            sb.append(stack.get(i));
        }
        System.out.println(sb.toString());
    }
}
