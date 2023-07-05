package leetCode.leetCode104;

class Solution {
    public int maxDepth(TreeNode root) {
        return height(root,0);
    }
    private static int height(TreeNode root, int h){
        if(root==null){
            return h;
        }
        int left = height(root.left, h+1);
        int right = height(root.right, h+1);

        return Math.max(left, right);
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
