/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || right == left) {
            return head;
            }
    
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevM = dummy;
    
        for (int i = 1; i < left; i++) {
            prevM = prevM.next;
        }

        ListNode currM = prevM.next;
        ListNode prev = null;
        ListNode next = null;

        for (int i = left; i <= right; i++) {
            next = currM.next;
            currM.next = prev;
            prev = currM;
            currM = next;
        }

        prevM.next.next = currM;
        prevM.next = prev;

       return dummy.next;
    }
}