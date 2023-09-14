package leetCode.leetCode404;
 
class Solution {
    static int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        leftSum(root, "");
        return ans;
    }
    static void leftSum(TreeNode node, String type){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(type.equals("L")){
                ans += node.val;
            }
            return;
        }
        leftSum(node.left, "L");
        leftSum(node.right, "R");
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
