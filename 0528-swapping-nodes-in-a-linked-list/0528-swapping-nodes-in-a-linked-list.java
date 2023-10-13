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

   public void swap(int ind1, int ind2, ArrayList<Integer> v) {
        int temp = v.get(ind2);
        v.set(ind2, v.get(ind1));
        v.set(ind1, temp);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ArrayList<Integer> v = new ArrayList<>();
        int count = 0;
        ListNode temp = head;

        
        while (temp != null) {
            v.add(temp.val);
            temp = temp.next;
            count++;
        }

        
        if (k < 1 || k > count)
            return head;

        swap(k - 1, count - k, v);

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = v.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }
}