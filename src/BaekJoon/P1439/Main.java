package BaekJoon.P1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1439
 * [1439번: 뒤집기]-Sliver5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] ch = str.toCharArray();
        int one = 0;
        int zero = 0;
        char temp = ch[0];
        for(int i=1; i<ch.length; i++){
            if(temp != ch[i]){
                if(temp=='1'){
                    one++;
                }else{
                    zero++;
                }
                temp = ch[i];
            }
        }
        if(ch[ch.length-1]=='1'){
            one++;
        }else{
            zero++;
        }
        System.out.println(Math.min(one,zero));
    }
}
