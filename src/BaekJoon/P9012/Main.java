package BaekJoon.P9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 * [9012번: 괄호]-Sliver4
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            System.out.println(check(str));
        }
    }
    static String check(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==')'){
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }else{
                stack.add(str.charAt(i));
            }
        }
        return stack.isEmpty()?"YES":"NO";
    }
}
