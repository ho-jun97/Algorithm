package BaekJoon.P2810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2810
 * [2810번: 컵홀더]-Bronze1
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int cup=1; // 시작은 무조건 1개는 넣을 수 있기 때문에 1부터 시작
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='S'){
                cup++;
            }else{
                cup++;
                i++;
            }
        }
        if(cup>N){ // N보다 크면 N
            System.out.println(N);
        }else{
            System.out.println(cup);
        }
    }
}
