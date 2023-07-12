package leetCode.leetCode112;

class Solution {
    static boolean ans;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ans = false;
        treeSum(root, 0, targetSum);
        return ans;
    }
    private void treeSum(TreeNode root, int sum, int target){
        if(root==null){
            return;
        }
        sum += root.val;
        if(root.left == null && root.right == null){
            if(target == sum){
                ans = true;
            }
            return;
        }
        treeSum(root.left, sum, target);
        treeSum(root.right, sum, target);
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
