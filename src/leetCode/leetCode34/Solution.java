package leetCode.leetCode34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};

        int first = nums.length;
        int last = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                first = Math.min(first, i);
                last = Math.max(last,i);
            }
        }
        
        if(last == -1 || first == nums.length){
            return ans;
        }
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
}
