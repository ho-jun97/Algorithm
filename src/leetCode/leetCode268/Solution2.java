package leetCode.leetCode268;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int allSum = n*(n+1)/2;
        for(int num : nums){
            allSum -= num;
        }
        return allSum;
    }
}
