package leetCode.leetCode169;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int std = nums.length/2;
        for(int key : map.keySet()){
            if(map.get(key) > std){
                return key;
            }
        }
        return 0;
    }
}
