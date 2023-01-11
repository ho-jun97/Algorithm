package Programmers._2개이하로다른비트;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            String binary = Long.toBinaryString(numbers[i]);
            if(!binary.contains("0")){
                answer[i] = Long.parseLong("10"+binary.substring(1),2);
            }else{
                String s = "";
                int index = binary.lastIndexOf("0");
                if(index < binary.length()-1){
                    s = binary.substring(0,index) + "10" + binary.substring(index+2);
                    answer[i] = Long.parseLong(s,2);
                }else{
                    s = binary.substring(0,index) +"1";
                    answer[i] = Long.parseLong(s,2);
                }
            }
        }
        return answer;
    }
}
