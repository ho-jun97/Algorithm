package BaekJoon.P1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.acmicpc.net/problem/1541
 * [1541번 : 잃어버린 괄호] - Silver2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        ArrayList<Integer> nums = new ArrayList<>(); // 플러스를 한 숫자들 저장
        for (int i = 0; i < str.length; i++) {
            if(str[i].contains("+")){
                int plusSum=0;
                /* split를 할 때 +는 특별한 의미를 갖고 있기 때문에 \를 사용해줘야한다.
                하지만, \은 단독으로 사용할 수 없기 때문에 \\을 쓴다.*/
                String[] temp = str[i].split("\\+");
                for (int j = 0; j < temp.length; j++) {
                      plusSum += Integer.parseInt(temp[j]);
                }
                nums.add(plusSum);
            }else{
                nums.add(Integer.parseInt(str[i]));
            }
        }
        int sum = nums.get(0);
        for (int i = 1; i <nums.size(); i++) { // 2번째 숫자들부터 -를 해준다.
            sum -= nums.get(i);
        }
        System.out.println(sum);

    }
}
