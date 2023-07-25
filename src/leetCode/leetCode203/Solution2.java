package leetCode.leetCode203;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode();
        ans.next = head;

        ListNode prev = ans;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        System.gc();
        return ans.next;
    }
}
