package leetCode.leetCode222;

class Solution {
    static int cnt;
    public int countNodes(TreeNode root) {
        cnt = 0;
        count(root);
        return cnt;
    }
    public void count(TreeNode node){
        if(node == null) {
            return;
        }
        cnt++;
        count(node.left);
        count(node.right);
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
