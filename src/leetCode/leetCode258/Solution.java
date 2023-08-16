package leetCode.leetCode258;

class Solution {
    public int addDigits(int num) {
        while(num > 9){
            int sum = 0;
            while(num > 0){
                int val = num % 10;
                sum += val;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
