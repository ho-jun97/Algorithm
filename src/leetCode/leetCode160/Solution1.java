package leetCode.leetCode160;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA != null){
            ListNode temp = headB;
            while(temp != null){
                if(headA == temp){
                    return temp;
                }
                temp = temp.next;
            }
            headA = headA.next;
        }
        return null;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
