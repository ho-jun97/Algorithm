package leetCode.leetCode257;

class Solution {
    static List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        path(root, "");
        return ans;
    }
    public void path(TreeNode node, String str){
        if(node == null){
            return;
        }
        if(node.left == null && node.right==null){
            ans.add(str+Integer.toString(node.val));
            return;
        }
        path(node.left, str+Integer.toString(node.val)+"->");
        path(node.right, str+Integer.toString(node.val)+"->");
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
