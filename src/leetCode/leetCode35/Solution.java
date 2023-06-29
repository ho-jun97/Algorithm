package leetCode.leetCode35

class Solution {
    public int searchInsert(int[] nums, int target) {
        // 1. 전체 배열을 돌면서 target과 비교 
        for(int i=0; i<nums.length; i++){
            // 2. 같은 값이거나 작으면 그 index 값 반환
            if(nums[i] >= target){
                return i;
            }
        }
        // 3. target 제일 큰 수 있므로 nums 길이 return
        return nums.length;
    }
}
