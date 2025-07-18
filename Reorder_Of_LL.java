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
		public void reorderList(ListNode head) {
            if(head == null || head.next == null) {
		        return;
		    }
		            
		    ListNode mid = middleNode(head);
		    ListNode hs = reverseList(mid);
		    ListNode hf = head;
		            
            //Rearrange
		    while(hf != null && hs != null) {
                ListNode temp = hf.next;
		        hf.next = hs;
		        hf = temp;
		            	
		        temp = hs.next;
		        hs.next = hf;
		        hs = temp;
		    }
		            
		            // next of tail to null
		    if(hf != null) {
		        hf.next = null;
		    }
		            
	}
		        public ListNode reverseList(ListNode head) {

		            if(head == null){
		                return head;
		            }
		            ListNode prev = null;
		            ListNode present = head;
		            ListNode next = present.next;



		            while(present != null){
		                present.next = prev;
		                prev = present;
		                present = next;
		                if(next != null){
		                    next = next.next;
		                }
		       
                    }
		            return prev;
		        }

    		        public ListNode middleNode(ListNode head) {
		            ListNode f = head;
		            ListNode s = head;

		            while(f != null && f.next != null){
		                f = f.next.next;
		                s = s.next;
		            }
		            return s;
		        }
}