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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, result = null;
        int carryOnValue = 0;
            
        while((l1 != null) && (l2 != null)) {
            int sum = l1.val + l2.val + carryOnValue;
            
            carryOnValue = sum / 10;
            sum %= 10;
            
            if (head != null) {
                head.next = new ListNode(sum);
                head = head.next;
            } else {
                result = head = new ListNode(sum);    
            }
            
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        while(l1 != null) {
            int sum = l1.val + carryOnValue;
            
            carryOnValue = sum / 10;
            sum %= 10;
            
            head.next = new ListNode(sum);
            head = head.next;
            
            l1 = l1.next;
        }
        
        while(l2 != null) {
            int sum = l2.val + carryOnValue;
            
            carryOnValue = sum / 10;
            sum %= 10;
            
            head.next = new ListNode(sum);
            head = head.next;
            
            l2 = l2.next;
        }
        
        if (carryOnValue != 0) {
            head.next = new ListNode(carryOnValue);
            head = head.next;
            carryOnValue = 0;
        }
        
        return result;     
    }
}
