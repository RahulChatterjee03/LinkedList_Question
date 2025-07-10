/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pos;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                ListNode entry = head;
                while(entry != slow){
                    entry = entry.next;
                    slow = slow.next; 
                }
                return entry;
            }
        }
        return null;
    }

}

/*  Step 2: Finding the start of the cycle Once slow and fast meet inside the cycle, the key idea is: From the head of the list, 
and from the meeting point inside the cycle, if we move one pointer from each of those positions one step at a time, they will meet at the start 
of the cycle.*/
