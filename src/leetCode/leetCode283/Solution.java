package leetCode.leetCode283;

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCntAndIndex = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[zeroCntAndIndex] = nums[i];
                zeroCntAndIndex++;
            }
        }
        while(zeroCntAndIndex < nums.length){
            nums[zeroCntAndIndex] = 0;
            zeroCntAndIndex++;
        }
    }
}
