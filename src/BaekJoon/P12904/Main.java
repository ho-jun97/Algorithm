package BaekJoon.P12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/12904
 * [12904번: A와 B]-Gold5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(change(S,T));
    }
    static int change(String S, String T){
        while(S.length()!=T.length()){
            if(T.charAt(T.length()-1) == 'A'){
                T = T.substring(0,T.length()-1);
            }else{
                T = T.substring(0,T.length()-1);
                T = reverse(T);
            }
        }
        if(S.equals(T)){
            return 1;
        }else{
            return 0;
        }
    }
    static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
