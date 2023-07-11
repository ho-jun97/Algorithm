package leetCode.leetCode111;

class Solution {
    static int ans;
    public int minDepth(TreeNode root) {
        ans = 100001;
        height(root, 0);
        return ans==100001?0:ans+1;
    }
    private void height(TreeNode root, int h){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans = Math.min(ans, h);
            return;
        }
        height(root.left, h+1);
        height(root.right, h+1);
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
