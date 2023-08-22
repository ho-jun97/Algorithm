package leetCode.leetCode303;

class NumArray {
    static int[] list;
    public NumArray(int[] nums) {
        list = new int[nums.length];
        list[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            list[i] = list[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return list[right];
        return list[right] - list[left-1];
    }
}
