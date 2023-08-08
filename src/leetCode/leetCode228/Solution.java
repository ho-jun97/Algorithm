package leetCode.leetCode228;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
        int start = nums[0];
        int cur = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == cur + 1){
                cur = nums[i];
                continue;
            }
            StringBuilder sb = new StringBuilder();
            if(start == cur){
                sb.append(Integer.toString(start));
            }else{
                sb.append(Integer.toString(start)).append("->").append(Integer.toString(cur));
            }

            list.add(sb.toString());
            start = nums[i];
            cur = nums[i];
        }
        StringBuilder sb = new StringBuilder();
        if(start == cur){
            sb.append(Integer.toString(start));
        }else{
            sb.append(Integer.toString(start)).append("->").append(Integer.toString(cur));
        }
        list.add(sb.toString());
        return list;
    }
}
