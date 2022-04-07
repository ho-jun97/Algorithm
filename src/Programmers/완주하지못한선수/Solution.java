package Programmers.완주하지못한선수;

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
//         HashMap<String, Integer> hash = new HashMap<>();

//         for(int i=0; i<participant.length; i++){
//             if(hash.containsKey(participant[i])){
//                 hash.replace(participant[i], hash.get(participant[i])+1);
//             }else{
//                 hash.put(participant[i],1);
//             }
//         }
//         for(int i=0; i<completion.length; i++){
//             hash.replace(completion[i], hash.get(completion[i])-1);
//         }
//         for(int i=0; i<participant.length; i++){
//             if(hash.get(participant[i])==1){
//                 answer = participant[i];
//                 break;
//             }
//         }
// ===================================================================
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0; i<completion.length;i++){
            if(!completion[i].equals(participant[i])){
                break;
            }

        }
        answer = participant[i];
        return answer;
    }
}
