package leetCode.leetCode101;

class Solution {
    static List<Integer> left;
    static List<Integer> right;
    public boolean isSymmetric(TreeNode root) {
        return find(root.left, root.right);
    }
    private static boolean find(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }    
        if(left != null && right != null && left.val == right.val){

            return find(left.left, right.right) && find(left.right, right.left);
        }
        return false;
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
