package leetCode.leetCode66;

class Solution {
    public int[] plusOne(int[] digits) {
        // 1. 맨 마지막에 +1 하기
        digits[digits.length-1]++;
        for(int i=digits.length-1; i>0; i--){
            // 10이면 현재 인덱스 값을 0으로 만들고 현재인덱스-1 값 1 증가
            if(digits[i] == 10){
                digits[i-1]++;
                digits[i] = 0;
            }
        }
        // 마지막 10이면 현재 배열 1증가 후 분리시키기
        if(digits[0] == 10){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }
}
