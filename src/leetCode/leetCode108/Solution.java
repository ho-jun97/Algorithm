package leetCode.leetCode108;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length-1);
    }
    private TreeNode create(int nums[], int s, int e){
        if(s > e) {
            return null;
        }
        int mid = (s+e)/2;
        
        return new TreeNode(
            nums[mid],
            create(nums, s, mid-1),
            create(nums, mid+1, e)
        );
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
