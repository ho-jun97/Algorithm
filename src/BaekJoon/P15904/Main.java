package BaekJoon.P15904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15904
 * [15904번: UCPC는 무엇의 약자일까?]-Silver5
 */

public class Main {
    static char[] ucpc = {'U','C','P','C'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        int index=0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c==ucpc[index]){
                index++;
            }
            if(index==4) break;
        }
        if(index==4){
            System.out.println("I love UCPC");
        }else{
            System.out.println("I hate UCPC");
        }
    }
}
