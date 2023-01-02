package Programmers.파일명정렬;

import java.util.*;
class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, (o1,o2)->{
            String[] f1 = divide(o1);
            String[] f2 = divide(o2);
            int com1 = f1[0].compareTo(f2[0]);
            if(com1 == 0){
                int num1 = Integer.parseInt(f1[1]);
                int num2 = Integer.parseInt(f2[1]);
                return Integer.compare(num1,num2);
            }
            return com1;
        });
        return files;
    }
    static String[] divide(String file){
        String head = "";
        String num = "";
        String tail = "";
        int index = 0;
        for( ; index<file.length(); index++){
            char c = file.charAt(index);
            if('0' <= c && c <= '9'){
                break;
            }
            head += c;
        }
        for( ; index<file.length(); index++){
            char c = file.charAt(index);
            if('0' > c || c > '9'){
                break;
            }
            num += c;
        }
        for( ; index<file.length(); index++){
            char c = file.charAt(index);
            tail += c;
        }
        return new String[]{head.toUpperCase(), num, tail};
    }
}
