package leetCode.leetCode448;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] check = new boolean[nums.length+1];
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            check[num] = true;   
        }
        for(int i=1; i<check.length; i++){
            if(!check[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}
