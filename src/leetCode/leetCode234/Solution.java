package leetCode.leetCode234;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode start = head;
        ListNode mid = middle(head);
        ListNode reverse = reverse(mid.next);

        while(reverse != null){
            if(reverse.val != start.val){
                return false;
            }
            start = start.next;
            reverse = reverse.next;
        }
        return true;
    }
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
