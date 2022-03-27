package BaekJoon.P10953;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/10953
 * [10953번: A+B - 6]-Bronze2
 */

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(",");
            System.out.println(Integer.parseInt(str[0])+Integer.parseInt(str[1]));
        }
    }
}