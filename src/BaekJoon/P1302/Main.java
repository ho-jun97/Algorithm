package BaekJoon.P1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * https://www.acmicpc.net/problem/1302
 * [1302번: 베스트셀러]-Silver4
 */

public class Main {
    static int N;
    static HashMap<String, Integer> hash;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hash = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(hash.containsKey(str)) {
                hash.replace(str, hash.get(str)+1);
            }else{
                hash.put(str,1);
            }
        }
        int max=0;
        for(String s : hash.keySet()){
            max = Math.max(max,hash.get(s));
        }
        String answer ="";
        ArrayList<String> list = new ArrayList<>(hash.keySet());
        Collections.sort(list);
        for(String s : list){
            if(max==hash.get(s)) answer = s;
        }
        System.out.println(answer);
    }

}
