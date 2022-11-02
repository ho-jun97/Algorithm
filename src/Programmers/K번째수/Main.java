package Programmers.K번째수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        Integer[] arr = new Integer[array.length];
        int index = 0;
        for(int i : array){
            arr[index++] = i;
        }
        int idx = 0;
        for(int[] command : commands) {
            List<Integer> list = new ArrayList<>(Arrays.asList(arr).subList((command[0] - 1), (command[1])));
            Collections.sort(list);
            answer[idx++] = list.get(command[2]-1);
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution.solution(array, commands);
    }
}
