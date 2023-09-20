package leetCode.leetCode414;

class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            pq.add(num);
        }

        int max = pq.poll();
        int before = max;
        int cnt = 1;
        while(!pq.isEmpty()){
            if(pq.peek() != before){
                cnt++;
                if(cnt == 3){
                    return pq.peek();
                }
            }
            before = pq.poll();
        }
        return max;
    }
}
